package com.github.rutledgepaulv

import scala.io.Source



object Problem1 extends App {
    print(Streams.merge(Stream.from(3, 3), Stream.from(5, 5)).distinct.takeWhile(_ < 1000).sum)
}

object Problem2 extends App {
    print(Fibonacci.stream.filter(_ % 2 == 0).takeWhile(_ < 4000000).sum)
}

object Problem4 extends App {
    val pairs = (100 until 999) cross (100 until 999)
    print(pairs.map((tuple) => tuple._1 * tuple._2).map(_.toString).filter(x => x.reverse == x).map(_.toInt).max)
}

object Problem5 extends App {
    print(Multiples.lcm(BigInt(1) until BigInt(20): _*))
}

object Problem6 extends App {
    val sumOfSquares = (BigInt(1) until BigInt(101)).map(_ pow 2).sum
    val squareOfSum = (BigInt(1) until BigInt(101)).sum pow 2
    println(squareOfSum - sumOfSquares)
}

object Problem8 extends App {
    val numbers = Readers.readFlat("8.txt").map(Mappers.toInt)
    print(numbers.sliding(13).map(_.map(BigInt.apply).product).max)
}

object Problem20 extends App {
    print(Factorial(100).toString.map(Mappers.toInt).sum)
}

object Problem22 extends App {
    val names = Readers.readQuoted("22.txt").sorted.zipWithIndex
    print(names.map(name => Alpha.sum(name._1) * (name._2 + 1)).map(BigInt.apply).sum)
}

object Problem24 extends App {
    val values = (0 until 10).permutations.map(_.mkString).toList.sorted
    print(values(999999))
}

object Problem25 extends App {
    print(Fibonacci.stream.map(_.toString).takeWhile(_.length < 1000).length + 1)
}

object Problem93 extends App {
    print(Arithmetic.permutations(List(1,2,3,4)))
}



object Readers {
    def readFlat(f: String): String = readLines(f).mkString

    def readLines(f: String): List[String] = {
        val stream = getClass.getResourceAsStream("/" + f)
        Source.fromInputStream(stream).getLines.toList
    }

    def readQuoted(f: String): List[String] = readFlat(f).split(",")
      .map(_.stripPrefix("\"").stripSuffix("\"")).toList

}

object Mappers {
    def toInt(x:Char): Int = x.toString.toInt
}

