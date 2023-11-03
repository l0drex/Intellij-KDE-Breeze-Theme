package com.github.l0drex.intellijkdebreezetheme.services

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BreezeThemeServiceTest : BasePlatformTestCase() {
    fun testGetAccentColor() {
        val theme = BreezeThemeService()
        val color = theme.getAccentColor()

        assertEquals(color, DEFAULT_COLOR)
    }
}