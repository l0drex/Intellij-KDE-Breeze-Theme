package com.github.l0drex.intellijkdebreezetheme.services

import org.freedesktop.dbus.connections.impl.DBusConnection
import org.freedesktop.dbus.connections.impl.DBusConnectionBuilder
import org.freedesktop.dbus.exceptions.DBusException
import org.freedesktop.dbus.exceptions.DBusExecutionException
import org.freedesktop.dbus.interfaces.DBusSigHandler
import org.freedesktop.dbus.types.Variant

val DEFAULT_COLOR = Triple(0.239216, 0.682353, 0.913725)

/**
 * Runs the given function using the specified class loader
 * @param contextClassLoader the context class loader that should be used instead of the current one
 * @param function function to be executed using the specified class loader
 */
fun <T> withContextClassLoader(contextClassLoader: ClassLoader, function: () -> T): T {
    // got this from https://github.com/weisJ/auto-dark-mode/blob/bf3f5d190f019c74529d6521d30c15a4adae58ef/base/src/main/java/com/github/weisj/darkmode/platform/ClassLoader.kt
    val currentLoader = Thread.currentThread().contextClassLoader
    val value: T
    try {
        Thread.currentThread().contextClassLoader = contextClassLoader
        value = function()
    } finally {
        Thread.currentThread().contextClassLoader = currentLoader
    }

    return value
}

interface FreedesktopConnection {
    val accentColor: Triple<Double, Double, Double>

    fun addSettingChangedHandler(sigHandler: DBusSigHandler<FreedesktopInterface.SettingChanged>)
    fun removeSettingChangedHandler(sigHandler: DBusSigHandler<FreedesktopInterface.SettingChanged>)

    companion object {
        operator fun invoke(): FreedesktopConnection {
            val connection = try {
                // Temporarily replace the current thread's contextClassLoader to work around dbus-java's naive service loading
                withContextClassLoader(Companion::class.java.classLoader) {
                    DBusConnectionBuilder.forSessionBus().build()
                }
            } catch (e: DBusException) {
                return NullFreedesktopConnection(e.message ?: "")
            } catch (e: DBusExecutionException) {
                return NullFreedesktopConnection(e.message ?: "")
            }
            return DBusFreedesktopConnection(connection)
        }
    }
}

internal class NullFreedesktopConnection(private val error: String) : FreedesktopConnection {
    override val accentColor: Triple<Double, Double, Double>
        get() = TODO("Not yet implemented")

    override fun addSettingChangedHandler(sigHandler: DBusSigHandler<FreedesktopInterface.SettingChanged>) {
        throw UnsupportedOperationException()
    }

    override fun removeSettingChangedHandler(sigHandler: DBusSigHandler<FreedesktopInterface.SettingChanged>) {
        throw UnsupportedOperationException()
    }

}

internal class DBusFreedesktopConnection(
        private val connection: DBusConnection
) : FreedesktopConnection {

    private val freedesktopInterface: FreedesktopInterface? = connection.getRemoteObject(
            "org.freedesktop.portal.Desktop",
            "/org/freedesktop/portal/desktop",
            FreedesktopInterface::class.java
    )

    override val accentColor: Triple<Double, Double, Double>
        get() {
            freedesktopInterface ?: return DEFAULT_COLOR

            val color = freedesktopInterface.runCatching {
                recursiveVariantValue(
                        Read(
                                FreedesktopInterface.APPEARANCE_NAMESPACE,
                                FreedesktopInterface.ACCENT_COLOR_KEY
                        )
                ) as Triple<*, *, *>
            }.getOrElse { return DEFAULT_COLOR }

            return color as Triple<Double, Double, Double>
        }

    override fun addSettingChangedHandler(sigHandler: DBusSigHandler<FreedesktopInterface.SettingChanged>) {
        connection.addSigHandler(FreedesktopInterface.SettingChanged::class.java, sigHandler)
    }

    override fun removeSettingChangedHandler(sigHandler: DBusSigHandler<FreedesktopInterface.SettingChanged>) =
            connection.removeSigHandler(FreedesktopInterface.SettingChanged::class.java, sigHandler)

    /**
     * Unpacks a Variant recursively and returns the inner value.
     * @see Variant
     */
    private fun recursiveVariantValue(variant: Variant<*>): Any {
        val value = variant.value
        return if (value !is Variant<*>) value else recursiveVariantValue(value)
    }
}
