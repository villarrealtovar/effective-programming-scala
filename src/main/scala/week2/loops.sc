import scala.annotation.tailrec

/*
  Example: Factorial

  The factorial of a positive integer n is the product of all positive
  integers less than or equal to n

  def factorial(n: Int): Int =
    1 * 2 * ... * (n - 2) * (n -1) * n
 */

// 1. iterating on Collections
def factorialFoldLeft(n: Int): Int =
  (1 to n). foldLeft(1)((result, x) => result * x)

println(factorialFoldLeft(5))

// Note: there is also an operation product
def factorialProduct(n: Int): Int =
  (1 to n).product

println(factorialProduct(5))

// 2. imperative loops
def factorialImperative(n: Int): Int = {
  var acc = 1
  var i = 1
  while (i < n) {
    i = i + 1
    acc = acc * i
  }
  acc
}

println(factorialImperative(5))

// 3. functional
def factorialFunctional(n: Int): Int =
  if (n == 0) {
    1
  } else {
    n * factorialFunctional(n - 1)
  }

println(factorialFunctional(5))