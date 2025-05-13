package com.github.guenhter.junit

import com.github.guenhter.Calculator
import com.github.guenhter.CalculatorImpl
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
        assert(calculator.add(1, 2) == 3)
    }
    @Test
    fun subtractionTest() {
        assert(calculator.subtract(1, 2) == -1)
    }
    @Test
    fun multiplicationTest() {
        assert(calculator.multiply(1, 2) == 2)
    }


    // B - better names?



    @Test
    fun `adding two numbers should be a positive sum when summing two positive numbers`() {
        assert(calculator.add(1, 2) == 3)
    }

    @Test
    fun `adding two numbers should be a negative number when one number is negative and absolute-bigger than the other`() {
        assert(calculator.add(1, -2) == -1)
    }
    @Test
    fun `adding two numbers should be a positive number when one number is negative and absolute-smaller than the other`() {
        assert(calculator.add(2, -1) == 1)
    }

    @Test
    fun `adding two numbers should be zero when one number is negative and absolute-equal to the positive one`() {
        assert(calculator.add(2, -2) == 0)
    }

    @Test
    fun `subtracting two numbers should be a positive sum when subtracting a negative number from a positive number`() {
        assert(calculator.subtract(2, -2) == 4)
    }

    @Test
    fun `subtracting two numbers should be a positive number when subtracting a positive number from a negative number`() {
        assert(calculator.subtract(-2, 2) == -4)
    }



    // C multiple values


    @Test
    fun `addition of two numbers`() {
        assert(calculator.add(1, 2) == 3)
        assert(calculator.add(1, 3) == 4)
        assert(calculator.add(5, 7) == 12)
        assert(calculator.add(-3, 3) == 0)
    }

    @Test
    fun `subtraction of two numbers`() {
        assert(calculator.subtract(1, 2) == -1)
        assert(calculator.subtract(1, 3) == -2)
        assert(calculator.subtract(5, 7) == -2)
        assert(calculator.subtract(-3, 3) == -6)
    }

    @Test
    fun `multiplication of two numbers`() {
        assert(calculator.multiply(1, 2) == 2)
        assert(calculator.multiply(1, 3) == 3)
        assert(calculator.multiply(5, 7) == 35)
        assert(calculator.multiply(-3, 3) == -9)
    }




    @ParameterizedTest
    @MethodSource(value = ["additionNumberProvider"])
    fun `addition of two numbers (with params)`(num1: Int, num2: Int, expected: Int) {
        assert(calculator.add(num1, num2) == expected)
    }

    @ParameterizedTest
    @MethodSource(value = ["subtractionNumberProvider"])
    fun `subtraction of two numbers (with params)`(num1: Int, num2: Int, expected: Int) {
        assert(calculator.subtract(num1, num2) == expected)
    }

    @ParameterizedTest
    @MethodSource(value = ["multiplyNumberProvider"])
    fun `multiplication of two numbers (with params)`(num1: Int, num2: Int, expected: Int) {
        assert(calculator.multiply(num1, num2) == expected)
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
