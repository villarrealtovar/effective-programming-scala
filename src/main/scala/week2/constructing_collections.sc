import scala.collection.mutable

/*
  Construction: Empty
 */
List.empty
mutable.ArrayBuffer.empty
Map.empty


List.empty[Int]
mutable.ArrayBuffer.empty[Double]
Map.empty[String, Boolean]

/*
  Constructing: Varargs
 */

List(1,2,3,4)
mutable.ArrayBuffer("a", "b", "c", "d")

Map("a" -> true, "e" -> true, "b" -> false)

/*
  Construction: Prepending and Appending Elements
 */
0 +: List(1,2,3)
mutable.ArrayBuffer("a", "b") :+ "c"


/*
  Constructing: Updating a Map
 */
Map("a" -> true) + ("e" -> true)
