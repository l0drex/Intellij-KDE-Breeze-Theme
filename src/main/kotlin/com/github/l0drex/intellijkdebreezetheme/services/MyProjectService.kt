package com.github.l0drex.intellijkdebreezetheme.services

import com.github.l0drex.intellijkdebreezetheme.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
