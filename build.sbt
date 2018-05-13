name := "serize-akka"
organization := "me.aki.serize"
version := "0.1"

scalaVersion := "2.12.6"

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.aki-ks" % "serize" % "0.1.0"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.12"
