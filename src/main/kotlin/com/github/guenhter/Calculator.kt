package com.github.guenhter


interface Calculator {
    fun add(a: Int, b: Int): Int
    fun subtract(a: Int, b: Int): Int
    fun multiply(a: Int, b: Int): Int
}

class CalculatorImpl : Calculator {
    override fun add(a: Int, b: Int) = a + b
    override fun subtract(a: Int, b: Int)  = a - b
    override fun multiply(a: Int, b: Int) = a * b
}
