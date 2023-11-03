package com.github.l0drex.intellijkdebreezetheme.listeners

import com.github.l0drex.intellijkdebreezetheme.services.BreezeThemeService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

internal class AppStartListener : ProjectActivity {
    override suspend fun execute(project: Project) {
        val color = project.service<BreezeThemeService>().getAccentColor()

        print(color)
    }
}
