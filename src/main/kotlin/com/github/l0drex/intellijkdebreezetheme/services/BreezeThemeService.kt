package com.github.l0drex.intellijkdebreezetheme.services

import com.intellij.openapi.components.Service

@Service
class BreezeThemeService {
    fun getAccentColor(): Triple<Double, Double, Double> {
        val monitorService = XdgAccentMonitorService()

        return monitorService.currentColor
    }
}
