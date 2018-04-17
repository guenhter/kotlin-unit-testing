package com.github.guenhter.junit

import com.github.guenhter.Calculator
import com.github.guenhter.CalculatorImpl
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


object CalculatorTest {

    private val calculator: Calculator = CalculatorImpl()



    // A writing tests

    @Test
    fun additionTest() {
        calculator.add(1, 2) `should be equal to` 3
    }
    @Test
    fun subtractionTest() {
        calculator.subtract(1, 2) `should be equal to` -1
    }
    @Test
    fun multiplicationTest() {
        calculator.multiply(1, 2) `should be equal to` 2
    }


    // B - better names?



    @Test
    fun `adding two numbers should be a positive sum when summing two positive numbers`() {
        calculator.add(1, 2) `should be equal to` 3
    }

    @Test
    fun `adding two numbers should be a negative number when one number is negative and absolute-bigger than the other`() {
        calculator.add(1, -2) `should be equal to` -1
    }
    @Test
    fun `adding two numbers should be a positive number when one number is negative and absolute-smaller than the other`() {
        calculator.add(2, -1) `should be equal to` 1
    }

    @Test
    fun `adding two numbers should be zero when one number is negative and absolute-equal to the positive one`() {
        calculator.add(2, -2) `should be equal to` 0
    }

    @Test
    fun `subtracting two numbers should be a positive sum when subtracting a negative number from a positive number`() {
        calculator.subtract(2, -2) `should be equal to` 4
    }

    @Test
    fun `subtracting two numbers should be a positive number when subtracting a positive number from a negative number`() {
        calculator.subtract(-2, 2) `should be equal to` -4
    }



    // C multiple values


    @Test
    fun `addition of two numbers`() {
        calculator.add(1, 2) `should be equal to` 3
        calculator.add(1, 3) `should be equal to` 4
        calculator.add(5, 7) `should be equal to` 12
        calculator.add(-3, 3) `should be equal to` 0
    }

    @Test
    fun `subtraction of two numbers`() {
        calculator.subtract(1, 2) `should be equal to` -1
        calculator.subtract(1, 3) `should be equal to` -2
        calculator.subtract(5, 7) `should be equal to` -2
        calculator.subtract(-3, 3) `should be equal to` -6
    }

    @Test
    fun `multiplication of two numbers`() {
        calculator.multiply(1, 2) `should be equal to` 2
        calculator.multiply(1, 3) `should be equal to` 3
        calculator.multiply(5, 7) `should be equal to` 35
        calculator.multiply(-3, 3) `should be equal to` -9
    }




    @ParameterizedTest
    @MethodSource(value = ["additionNumberProvider"])
    fun `addition of two numbers (with params)`(num1: Int, num2: Int, expected: Int) {
        calculator.add(num1, num2) `should be equal to` expected
    }

    @ParameterizedTest
    @MethodSource(value = ["subtractionNumberProvider"])
    fun `subtraction of two numbers (with params)`(num1: Int, num2: Int, expected: Int) {
        calculator.subtract(num1, num2) `should be equal to` expected
    }

    @ParameterizedTest
    @MethodSource(value = ["multiplyNumberProvider"])
    fun `multiplication of two numbers (with params)`(num1: Int, num2: Int, expected: Int) {
        calculator.multiply(num1, num2) `should be equal to` expected
    }

    @JvmStatic
    fun additionNumberProvider(): Stream<Arguments> {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, 3, 4),
                Arguments.of(5, 7, 12),
                Arguments.of(-3, 3, 0))
    }
    @JvmStatic
    fun subtractionNumberProvider(): Stream<Arguments> {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(1, 3, -2),
                Arguments.of(5, 7, -2),
                Arguments.of(-3, 3, -6))
    }
    @JvmStatic
    fun multiplyNumberProvider(): Stream<Arguments> {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(1, 3, 3),
                Arguments.of(5, 7, 35),
                Arguments.of(-3, 3, -9))
    }
}
