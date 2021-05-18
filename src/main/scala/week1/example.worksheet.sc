1 + 1

val x = 42

x * x

case class Square(width: Double) {
  val area = width * width
}

case class Circle(radius: Double) {
  val area = radius * radius * Math.PI
}

sealed trait Shape
case class Rectangle(width: Double, height: Double) extends Shape
case class Circle2(radius: Double) extends Shape

val shapeArea = (someShape: Shape) => {
  someShape match {
    case Rectangle(width, height) => width * height // No exhaustive
  }
}

val shapeArea2 = (someShape: Shape) => {
  someShape match {
    case circle: Circle2 => s"This is a circle with radius ${circle.radius}"
    case _ => "This is not a circle"
  }
}

/*
  Exercise: Model the actions that a user can perform in a messaging system:

  - subscribe to a channel
  - unsubscribe from a channel
  - or post a message to a channel

  A channel has a name
 */
sealed trait Action
case class Subscribe(channel: Channel) extends Action
case class Unsubscribe(channel: Channel) extends Action
case class Post(channel: Channel, message: String) extends Action

case class Channel(name: String)


/*
  Exercise: Define a value representing the action of subscribing to a
  channel named "effective-scala"
 */

val subscribeEffectiveScala = Subscribe(Channel("effective-scala"))
