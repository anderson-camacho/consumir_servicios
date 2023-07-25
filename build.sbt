name := """consumir_servicios"""
organization := "com.camacho"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.11"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
libraryDependencies += ws
libraryDependencies += "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.10.0"
libraryDependencies += "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.10.0"
libraryDependencies += "com.lihaoyi" %% "requests" % "0.8.0"
libraryDependencies += "com.lihaoyi" %% "upickle" % "3.1.2"
libraryDependencies += "org.mockito" % "mockito-core" % "3.12.4" % Test
