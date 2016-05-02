package com.github.rutledgepaulv

object Streams {

    def merge[A](stream1: Stream[A], stream2: Stream[A])(implicit ev$1: A => BigInt): Stream[A] = {
        (stream1, stream2) match {
            case (Stream.Empty, bss) => bss
            case (ass, Stream.Empty) => ass
            case (a #:: ass, b #:: bss) =>
                if (a < b)
                    a #:: merge(ass, stream2)
                else
                    b #:: merge(stream1, bss)
        }
    }

}
