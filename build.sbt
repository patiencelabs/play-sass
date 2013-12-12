name := "play-sass"

version := "0.2.3"

crossScalaVersions := Seq("2.9.1","2.10.2")

sbtPlugin := true

organization := "net.litola"

description := "SBT plugin for handling Sass assets in Play 2.1"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += new MavenRepository("typesafe-releases", "http://repo.typesafe.com/typesafe/releases/")

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += Resolver.file("LocalIvy", file(Path.userHome + "/.ivy2/local"))(Resolver.ivyStylePatterns)

resolvers += "Everreach Third Party" at "http://ec2-54-229-115-100.eu-west-1.compute.amazonaws.com:9090/nexus/content/repositories/thirdparty"

publishTo in ThisBuild <<= version { (v: String) =>
  val nexus = "http://ec2-54-229-115-100.eu-west-1.compute.amazonaws.com:9090/nexus/content/repositories/"
  if (v.trim.endsWith("SNAPSHOT")) Some("Everreach snapshots" at nexus + "snapshots")
  else Some("Everreach releases" at nexus + "releases")
}

publishMavenStyle in ThisBuild:= true

publishArtifact in Test in ThisBuild := false

pomIncludeRepository in ThisBuild := { x => false }

credentials in ThisBuild += Credentials(new File(sys.env.get("EVERREACH_NEXUS_CREDENTIALS").getOrElse("/etc/everreach/nexus.credentials")))

/// Dependencies

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.1")