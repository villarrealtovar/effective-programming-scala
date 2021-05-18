/*
  Example: Basketball

  Given the position of a basketball player, and a shot direction and force,
  is the ball going to pass through the hoop?

  To check whether the ball passed through the hoop, we compute the
  distance between the center of the hoop and the straight segment made
  of two successive positions.

 */

case class Position(x: Double, y: Double) {
  def distanceTo(that: Position): Double = ???
  def distanceToLine(line: (Position, Position)): Double = ???
}

object Position {
  val player = Position(0, 1.80)
  val hoop = Position(6.75, 3.048)
}

case class Angle(radians: Double)
case class Speed(metersPerSecond: Double)

def isWinningShot(angle: Angle, speed: Speed): Boolean = {
  val v0x = speed.metersPerSecond * math.cos(angle.radians)
  val v0Y = speed.metersPerSecond * math.sin(angle.radians)
  val p0X = Position.player.x
  val p0Y = Position.player.y
  val g = -9.81

  def goesThroughHoop(line: (Position, Position)): Boolean =
    Position.hoop.distanceToLine(line) < 0.01

  def isNotTooFar(position: Position): Boolean =
    position.y > 0 && position.x <= Position.hoop.x + 0.01

  def position(t: Int): Position = {
    val x = p0X + v0x * t
    val y = p0Y + v0Y * t + 0.5 * g * t * t
    Position(x, y)
  }
  // 1. Solution based on collections
  /*
  val timings = LazyList.from(0)
  val positions = timings.map(position)
  val lines = positions.zip(positions.tail)
  lines
    .takeWhile(p1 => isNotTooFar(p1._1))
    .exists(goesThroughHoop)
  */

  // 2. Solution based on imperative loops
  /*
  var time = 0
  var previousPosition = position(time)
  var isWinning = false
  while (isNotTooFar(previousPosition) && !isWinning) {
    time = time + 1
    val nextPosition = position(time)
    val line = (previousPosition, nextPosition)
    isWinning = goesThroughHoop(line)
    previousPosition = nextPosition
  }
  isWinning
  */

  // 3. recursive method
  def loop(time: Int): Boolean = {
    val currentPosition = position(time)
    if (isNotTooFar(currentPosition)) {
      val nextPosition = position(time + 1)
      val line = (currentPosition, nextPosition)
      goesThroughHoop(line) || loop(time + 1)
    } else {
      false
    }

  }

  loop(time = 0)

}

val angle = Angle(1.4862)
val speed = Speed(20)

// isWinningShot(angle, speed)


/*
  Example: Task Management

  cs setup <-------
                  |
  IDE <-------   Hack   <----- Deploy

  Question: When can I expect the deploy task to be finished at best?
 */
case class Task(name: String, duration: Int, requirements: List[Task])

val csSetup = Task("cs setup", 4, Nil)
val ide = Task("IDE", 3, Nil)
val hack = Task("hack", 8, List(csSetup, ide))
val deploy = Task("deploy", 3, List(hack))


/*  Using Recursion

  def maxTotalDuration(tasks: List[Task]): Int =
  tasks match {
    case Nil => 0
    case head :: tail =>
      val headDuration = totalDuration(head)
      val tailDuration = maxTotalDuration(tail)
      if (headDuration < tailDuration) tailDuration else headDuration
  }

  /*
    returns: Int - the time it takes to complete
                including all the tasks and it depends on.
   */
  def totalDuration(task: Task): Int =
    task.duration + maxTotalDuration(task.requirements)

  */

  def totalDuration(task: Task): Int = {
    val requirementsMaxTotalDuration =
        task.requirements
          .map(totalDuration)
          .maxOption
          .getOrElse(0)

    task.duration + requirementsMaxTotalDuration
  }



println(totalDuration(deploy))


