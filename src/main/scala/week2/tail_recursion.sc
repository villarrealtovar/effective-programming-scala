import scala.annotation.tailrec

// 3. functional
def factorialFunctional(n: Double): Double = {
  @tailrec
  def factorialTailRecursion(x: Double, accum: Double): Double = {
    if (x == 0) accum
    else factorialTailRecursion(x - 1, x * accum)
  }
  factorialTailRecursion(n, 1)
}

println(factorialFunctional(1))
println(factorialFunctional(2))
println(factorialFunctional(3))
println(factorialFunctional(4))
println(factorialFunctional(5))
println(factorialFunctional(100))

