package com.github.rutledgepaulv

object Groupers {


    def allGroupings[A](original: List[A]): List[List[List[A]]] = {
        (1 until original.size).map(x => List(x).cross(0 until x - 1).flatMap(x =>
            original.sliding(x._1 + x._2, x._1 + x._2)).toList).toList ++ List(List(original))
    }

}


object Test extends App {
    print(Groupers.allGroupings(List(1,2,3,4)))


    List(List(List(1), List(2,3,4)))

}