package com.github.rutledgepaulv

import scala.math.BigInt

object Factorial {

    private object func extends ((BigInt) => BigInt) {
        val func: (BigInt) => BigInt = Memoize(apply)
        def apply(x: BigInt): BigInt = x match {
            case bigInt(1) => 1
            case y => y * func(y - 1)
        }
    }

    def apply(x:BigInt):BigInt = func.apply(x)

}
