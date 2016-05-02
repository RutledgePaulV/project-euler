package com.github.rutledgepaulv

import scala.collection.mutable


object Memoize {

    private class Memoize[A, B](func: A => B) extends (A => B) {
        private val cache: mutable.Map[A, B] = mutable.Map[A, B]()
        override def apply(argument: A): B = {
            if (cache.contains(argument)) cache.get(argument).get else {
                val result = func(argument)
                cache.put(argument, result)
                result
            }
        }
    }


    def apply[A, B](func: A => B): A => B = new Memoize(func)
}