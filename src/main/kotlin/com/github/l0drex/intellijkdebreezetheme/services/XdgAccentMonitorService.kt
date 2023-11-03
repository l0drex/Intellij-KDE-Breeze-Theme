package com.github.l0drex.intellijkdebreezetheme.services

import org.freedesktop.dbus.interfaces.DBusSigHandler

class XdgAccentMonitorService {
    private val freedesktopConnection = FreedesktopConnection()
    private val sigHandler = SigHandler()
    val currentColor: Triple<Double, Double, Double> get() = freedesktopConnection.accentColor
}


private class SigHandler : DBusSigHandler<FreedesktopInterface.SettingChanged> {
    var eventHandler: (() -> Unit)? = null
    override fun handle(signal: FreedesktopInterface.SettingChanged) {
        if (signal.accentColorChanged) {
            eventHandler?.invoke()
        }
    }
}
