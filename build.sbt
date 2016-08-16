name := "IntelliTraj"

version := "1.0"

scalaVersion := "2.11.8"


// https://mvnrepository.com/artifact/joda-time/joda-time
// libraryDependencies +=

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.2",
  "org.apache.spark" %% "spark-mllib" % "1.6.2",
  "com.github.nscala-time" %% "nscala-time" % "2.12.0",
  "com.esri.geometry" % "esri-geometry-api" % "1.2.1",
  "io.spray" %% "spray-json" % "1.3.2",
  "joda-time" % "joda-time" % "2.9.4",
  "org.apache.hadoop" % "hadoop-client" % "2.6.3"
)