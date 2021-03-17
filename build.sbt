name := "slick3"
description := "Scala slick 3 examples"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "com.pagero" %% "pagero-slick" % "1.8.1-GO",
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)

