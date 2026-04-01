package com.github.guenhter.kotest

import com.github.guenhter.CalculatorImpl
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertEquals

class CalculatorKotest : DescribeSpec({
    describe("a calculator") {
        val calculator = CalculatorImpl()

        context("adding two numbers") {
            it("should be a positive sum when summing two positive numbers") {
                calculator.add(1, 2) shouldBe 3
            }
            it("should be a negative number when one number is negative and absolute-bigger than the other") {
                calculator.add(1, -2) shouldBe -1
            }
            it("should be a positive number when one number is negative and absolute-smaller than the other") {
                calculator.add(2, -1) shouldBe 1
            }
            it("should be zero when one number is negative and absolute-equal to the positive one") {
                calculator.add(2, -2) shouldBe 0
            }
        }

        context("subtracting two numbers") {
            it("should be a positive sum when subtracting a negative number from a positive number") {
                calculator.subtract(2, -2) shouldBe 4
            }
            it("should be a positive number when subtracting a positive number from a negative number") {
                calculator.subtract(-2, 2) shouldBe -4
            }
        }
    }
})

// B - Assertions

class AssertionsKotest : DescribeSpec({
    describe("a calculator") {
        val calculator = CalculatorImpl()

        it("check some assertions") {
            // JUnit-style assertion
            assertEquals(3, calculator.add(1, 2))

            // Kotlin assert (enhanced by power-assert plugin)
            assert(calculator.add(1, 2) == 3)

            // Kotest-style assertion (idiomatic Kotlin)
            calculator.add(1, 2) shouldBe 3
        }
    }
})


// C - Data-driven testing (this was missing in Spek2 — Kotest supports it natively!)

class CalculatorDataDrivenKotest : DescribeSpec({
    describe("a calculator") {
        val calculator = CalculatorImpl()

        describe("addition") {
            listOf(
                Triple(1, 2, 3),
                Triple(1, 3, 4),
                Triple(5, 7, 12),
                Triple(-3, 3, 0),
            ).forEach { (a, b, expected) ->
                it("$a + $b = $expected") {
                    calculator.add(a, b) shouldBe expected
                }
            }
        }

        describe("subtraction") {
            listOf(
                Triple(1, 2, -1),
                Triple(1, 3, -2),
                Triple(5, 7, -2),
                Triple(-3, 3, -6),
            ).forEach { (a, b, expected) ->
                it("$a - $b = $expected") {
                    calculator.subtract(a, b) shouldBe expected
                }
            }
        }

        describe("multiplication") {
            listOf(
                Triple(1, 2, 2),
                Triple(1, 3, 3),
                Triple(5, 7, 35),
                Triple(-3, 3, -9),
            ).forEach { (a, b, expected) ->
                it("$a * $b = $expected") {
                    calculator.multiply(a, b) shouldBe expected
                }
            }
        }
    }
})
