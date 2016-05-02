package com.github.rutledgepaulv

object Alpha {

    def sum(s: String) = s.map(_.toLower).map(_.toInt - 'a'.toInt + 1).sum

}
