package com.github

import scala.math.BigInt

package object rutledgepaulv {
    object bigInt {
        def unapply(n: BigInt) = Some(n.toInt)
    }

    implicit class Crossable[X](xs: Traversable[X]) {
        def cross[Y](ys: Traversable[Y]) = for { x <- xs; y <- ys } yield (x, y)
    }

}
