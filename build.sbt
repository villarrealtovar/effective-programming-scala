name := "effective-programming-scala"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= List(
  "com.lihaoyi" %% "fansi" % "0.2.14",
   "org.scalameta" %% "munit" % "0.7.26" % Test
)

testFrameworks += TestFramework("munit.Framework")

makeSite / mappings := {
  val indexFile = target.value / "index.html"
  IO.write(indexFile, "<h1>Hello, sbt</h1>")
  Seq(indexFile -> "index.html")
}


unmanagedSources / includeFilter := new io.ExtensionFilter(
  "java",
  "scala",
  "sc"
)
