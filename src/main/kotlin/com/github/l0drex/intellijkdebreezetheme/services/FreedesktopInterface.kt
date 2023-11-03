package com.github.l0drex.intellijkdebreezetheme.services

import org.freedesktop.dbus.annotations.DBusInterfaceName
import org.freedesktop.dbus.interfaces.DBusInterface
import org.freedesktop.dbus.messages.DBusSignal
import org.freedesktop.dbus.types.Variant

@Suppress("FunctionName")
@DBusInterfaceName("org.freedesktop.portal.Settings")
interface FreedesktopInterface : DBusInterface {
    companion object {
        const val APPEARANCE_NAMESPACE = "org.freedesktop.appearance"
        const val ACCENT_COLOR_KEY = "accent-color"
        /*
        Indicates the system's preferred accent color as a tuple of RGB values
          in the sRGB color space, in the range [0,1].
          Out-of-range RGB values should be treated as an unset accent color.
         */
    }

    fun Read(namespace: String, key: String): Variant<*>

    class SettingChanged(objectpath: String, namespace: String, key: String, value: Variant<Any>) :
            DBusSignal(objectpath, namespace, key, value) {
        val accentColorChanged: Boolean =
                namespace == APPEARANCE_NAMESPACE && key == ACCENT_COLOR_KEY
    }
}