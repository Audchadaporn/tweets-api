name := "shout-api"

version := "0.1"

scalaVersion := "2.12.7"

val akkaHttpVersion = "10.1.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-stream" % "2.5.13",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-xml" % akkaHttpVersion,
  "joda-time" % "joda-time" % "2.10",
  "com.github.cb372" %% "scalacache-guava" % "0.9.3",
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.mockito" % "mockito-core" % "2.8.47" % "test"
)
