package com.github.guenhter.junit

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


private class Ex1PrintOutExtension : PrintOutExtension(printPrefix = "---")
private class Ex2PrintOutExtension : PrintOutExtension(printPrefix = "xxx")

@ExtendWith(value = [Ex1PrintOutExtension::class, Ex2PrintOutExtension::class])
class TwoExtensionsTest1 {
    @Test
    fun `it is true`() { }
}

@ExtendWith(value = [Ex2PrintOutExtension::class, Ex1PrintOutExtension::class])
class TwoExtensionsTest2 {
    @Test
    fun `it is true`() { }
}