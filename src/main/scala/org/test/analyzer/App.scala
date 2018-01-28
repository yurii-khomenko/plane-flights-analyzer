package org.test.analyzer

import org.test.analyzer.helper.CommandLineExtractor
import org.test.analyzer.helper.CommonHelper._
import org.test.analyzer.service.Tasks._

object App extends App {

  val rootDir = "data"
  val inFileName = s"$rootDir/planes_log.csv.gz"
  val outFileNameTask1 = s"$rootDir/task1.csv.gz"
  val outFileNameTask2 = s"$rootDir/task2.csv.gz"
  val outFileNameTask3 = s"$rootDir/task3.csv.gz"

  val CommandLineExtractor(task) = args

  val startTime = currentTime
  val startMem = currentHeap

  task match {
    case "1" => task1(inFileName, outFileNameTask1)
    case "2" => task2(inFileName, outFileNameTask2)
    case "3" => task3(inFileName, outFileNameTask3)
    case _ => printUnknownTaskAndExit()
  }

  printCheckPath(rootDir)

  printMemoryConsumed(startMem)
  printSpentTime(startTime)
}