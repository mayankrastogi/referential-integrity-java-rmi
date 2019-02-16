import scala.sys.process.Process

name := "mayank_k_rastogi_hw3"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  // Logback logging framework
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",

  // JUnit testing framework
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test->default"
)

lazy val startRegistry = taskKey[Unit]("Starts RMI registry service")

startRegistry := {
  val log = streams.value.log

  log.info("Starting RMI Registry...")

  // Launch RMI registry process and redirect any outputs to logger
  Process("rmiregistry", target.value / "scala-2.12/classes").run(log)

  log.info("RMI registry started")
}