import scala.collection.mutable

// Map
val list = List(1,2,3,4)
list.map(x => x + 1)

val buff = mutable.ArrayBuffer(1,2,3,4)
buff.map(x => x % 2)

val myMap = Map(0 -> "No", 1 -> "Yes")
// myMap.map((key, value) => key -> (value * 2))

// Flatmap
List(1,2,3).flatMap(x => List())
mutable.ArrayBuffer(1,2).flatMap(x => mutable.ArrayBuffer(x, x * 2))

/*
Map(0 -> "zero", 1 -> "one").flatMap((key, _) =>
  Map(key.toString -> key)
) */

// FoldLeft
List(1,2,3).foldLeft(0)((accum, elt) => accum + elt)

List(1,2,3).foldLeft(List.empty[Int])((accum, elt) =>
elt +: accum
)

List(1,2,3, 4).foldLeft(true)((accum, elt) => elt % 2 == 0)


// GroupBy
val emails = List("andres@sca.la", "carito@sca.la", "thiago@vil.la")

// partition function
val domain: String => String = email => email.dropWhile(c=> c != "@").drop(1)

val emailsByDomain = emails.groupBy(domain)

println(emailsByDomain)

