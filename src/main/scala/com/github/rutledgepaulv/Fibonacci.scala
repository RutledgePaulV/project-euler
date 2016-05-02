package com.github.rutledgepaulv
import scala.math.BigInt


object Fibonacci {

    private object func extends ((BigInt) => BigInt) {
        val func: (BigInt) => BigInt = Memoize(apply)
        def apply(x: BigInt): BigInt = x match {
            case bigInt(0) | bigInt(1) => 1
            case _ => func(x - 1) + func(x - 2)
        }
    }

    def stream = Stream.from(0).map(BigInt.apply).map(func)

}