package com.github.guenhter.junit

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.*

open class PrintOutExtension(private val printPrefix: String = "Hi") :
        BeforeAllCallback, AfterAllCallback, TestInstancePostProcessor, BeforeEachCallback,
        AfterEachCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {
    override fun beforeAll(context: ExtensionContext) {
        printOut(PrintOutExtension::beforeAll.name)
    }
    override fun afterAll(context: ExtensionContext) {
        printOut(PrintOutExtension::afterAll.name)
    }
    override fun postProcessTestInstance(testInstance: Any, context: ExtensionContext) {
        printOut(PrintOutExtension::postProcessTestInstance.name)
    }
    override fun beforeEach(context: ExtensionContext) {
        printOut(PrintOutExtension::beforeEach.name)
    }
    override fun afterEach(context: ExtensionContext) {
        printOut(PrintOutExtension::afterEach.name)
    }
    override fun beforeTestExecution(context: ExtensionContext) {
        printOut(PrintOutExtension::beforeTestExecution.name)
    }
    override fun afterTestExecution(context: ExtensionContext) {
        printOut(PrintOutExtension::afterTestExecution.name)
    }
    private fun printOut(msg: String) {
        println("$printPrefix $msg")
    }
}


@ExtendWith(value = [PrintOutExtension::class])
class FooTest {
    @Test
    fun `it is true`() { }
}

@ExtendWith(value = [PrintOutExtension::class])
class BarTest {
    @Test
    fun `it is true`() { }
}

@ExtendWith(value = [PrintOutExtension::class])
class YoloTest {
    @Test
    fun `it is true`() { }
}
