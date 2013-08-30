name := "play-sass"

version := "0.2.2"

crossScalaVersions := Seq("2.9.2")

sbtPlugin := true

organization := "net.litola"

description := "SBT plugin for handling Sass assets in Play 2.1"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

publishTo := Some(Resolver.sftp("Patience", "repo.patience.io", "repo"))

resolvers += new MavenRepository("typesafe-releases", "http://repo.typesafe.com/typesafe/releases/")

/// Dependencies

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

addSbtPlugin("play" % "sbt-plugin" % "2.1.3")
