package com.github.rutledgepaulv

import scala.annotation.tailrec

object Multiples {

    @tailrec
    private def gcd(a: BigInt, b:BigInt):BigInt = {
        b match {
            case bigInt(0) => a
            case _ => gcd(b, a mod b)
        }
    }

    private def lcm(a: BigInt, b:BigInt):BigInt = (a * b) / gcd(a , b)



    def lcm(vals: BigInt*):BigInt = vals.reduce(lcm)

    def gcd(vals: BigInt*):BigInt = vals.reduce(gcd)

}
