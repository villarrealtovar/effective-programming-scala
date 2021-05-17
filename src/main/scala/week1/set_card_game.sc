/*
  Set Card Game

  Set (https://en.wikipeida.org/wiki/Set_(card_game) is a card game where three cards can make up a "set" if they satisfy
  some properties.

  Rules:

  1. Cards have four features across three possibilities for each kind of features:
    * shape: diamond
    * number of shape: 1, 2 or 3
    * shading: solid, striped or open
    * color: red, green or purple

  2. Three cards make up a set if and only if all the following properties are
    satisfied:
    * they all have the same number of shapes or have three different numbers
      of shapes
    * they all have the same shape or have three different shapes
    * they all have the same shading or have three different shadings
    * they all have the same color or have three different colors

    Exercise:

    Implement a method that takes three cards of the set game and returns whether
    they form a valid "set" or not
 */

// Domain Objects
sealed trait Shape
object Diamond extends Shape
object Squiggle extends Shape
object Ovel extends Shape

sealed trait Color
object Red extends Color
object Green extends Color
object Purple extends Color

sealed trait Shading
object Open extends Shading
object Striped extends Shading
object Solid extends Shading

/*
  case class Card(shape: Shape, number: Int, color: Color, shading: Shading)

  val nonSensicalCard0 = Card(Diamond, 0, Purple, Striped) // 0 value??? that doesn't make sense
  val nonSensicalCard42 = Card(Diamond, 42, Purple, Striped) // 42 value??? that doesn't make sense
  val nonSensicalCardNegative = Card(Diamond, -1, Purple, Striped) // 42 value??? that doesn't make sense

  Therefore, I can avoid this creating a different Type for `number`

  case class Card(shape: Shape, number: Number, color: Color, shading: Shading)


 */

sealed trait Number
object One extends Number
object Two extends Number
object Three extends Number

case class Card(shape: Shape, number: Number, color: Color, shading: Shading)


val deck = List(
  Card(Diamond, One, Purple, Striped),
  Card(Squiggle, Two, Red, Open),
  Card(Ovel, Three, Green, Solid),
)

// business logic
def checkProperty[T](property1: T, property2: T, property3: T): Boolean = {
  def allSame =
    property1 == property2 &&
    property1 == property3

  def allDifferent =
    property1 != property2 &&
    property1 != property3 &&
    property2 != property3

  allSame || allDifferent
}

def isValidSet(card1: Card, card2: Card, card3: Card): Boolean = {
  checkProperty[Shape](card1.shape, card2.shape, card3.shape) &&
  checkProperty[Number](card1.number, card2.number, card3.number) &&
    checkProperty[Shading](card1.shading, card2.shading, card3.shading) &&
    checkProperty[Color](card1.color, card2.color, card3.color)
}

isValidSet(
  Card(Diamond, One, Purple, Striped),
  Card(Squiggle, Two, Red, Open),
  Card(Ovel, Three, Green, Solid)
)

isValidSet(
  Card(Diamond, One, Purple, Striped),
  Card(Squiggle, Three, Red, Open),
  Card(Ovel, Three, Green, Solid)
)