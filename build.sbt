name := "akka-addressing"
version := "0.0.1"
scalaVersion := "2.11.7"

scalacOptions := Seq( "-unchecked", "-deprecation", "-feature" )
fork in run := true
mainClass in Compile := Some("Main")

/* Production dependencies */
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.10"
)
