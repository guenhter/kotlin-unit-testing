package com.github.guenhter.junit

import com.github.blindpirate.junit.extension.unroll.Param
import com.github.blindpirate.junit.extension.unroll.Unroll
import com.github.blindpirate.junit.extension.unroll.where
import org.assertj.core.api.Assertions.assertThat
import kotlin.math.max

class UnrollExtesionTest {

    @Unroll
    fun `max number of {0} and {1} is {2}`(
        a: Int, b: Int, c: Int, param: Param = where {
            1 _ 3 _ 3
            7 _ 4 _ 7
            0 _ 0 _ 0
        }) {
        assertThat(max(a, b)).isEqualTo(c)
    }
}
