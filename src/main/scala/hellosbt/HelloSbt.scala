package hellosbt

import scala.annotation.tailrec




object HelloSbt extends App {
  val greeting = "Hello sbt!!!"

  println(fansi.Color.Red(greeting))
}

