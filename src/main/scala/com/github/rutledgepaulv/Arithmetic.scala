package com.github.rutledgepaulv

object Arithmetic {

    private val defaultOperators: List[(Int, Int) => Int] = List(_ + _, _ - _, _ / _, _ * _)

    private def rotatedView[A](seq: List[A], i: Int): List[A] = seq.drop(i) ++ seq.take(i)

    private def allOrderings[A](x: List[A]): List[List[A]] = (1 until x.size).map(rotatedView(x, _)).toList

    private def intercalate(a: List[Any], b: List[Any]): List[Any] = a match {
        case first :: rest => first :: intercalate(b, rest)
        case _ => b
    }


    def permutations(numbers: List[Int], operators: List[(Int, Int) => Int] = defaultOperators): List[Int] = {
        val operatorPermutations = defaultOperators.combinations(numbers.size - 1).toList
        val numberPermutations = allOrderings(numbers)

        numberPermutations.flatMap(nums => operatorPermutations.map(permutation => {
            val values = intercalate(nums, permutation)
            print(values)
            Nil
        }))
        Nil
    }

}
