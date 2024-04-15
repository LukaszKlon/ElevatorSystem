ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "AVSystems"
  )
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.13.2" % "test",
  "org.scalatest" %% "scalatest" % "3.2.18" % "test",
  "com.typesafe.akka" %% "akka-actor" % "2.8.5"
)
