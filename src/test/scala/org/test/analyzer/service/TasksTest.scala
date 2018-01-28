package org.test.analyzer.service

import java.io.File

import org.specs2.mutable.Specification
import org.test.analyzer.service.Tasks._

class TasksTest extends Specification with Helper {

  val rootDir = "data"
  val inFilePath = s"$rootDir/planes_log.csv.gz"
  val outFilePathTask1 = s"$rootDir/task1.csv.gz"
  val outFilePathTask2 = s"$rootDir/task2.csv.gz"
  val outFilePathTask3 = s"$rootDir/task3.csv.gz"

  sequential

  "TasksTest" should {
    "task1 generate file task1.csv.gz" in {
      task1(inFilePath, outFilePathTask1)
      new File(outFilePathTask1).exists() === true
    }

    "task2 generate file task2.csv.gz" in {
      task2(inFilePath, outFilePathTask2)
      new File(outFilePathTask2).exists() === true
    }

    "task3 generate file task3.csv.gz" in {
      task3(inFilePath, outFilePathTask3)
      new File(outFilePathTask3).exists() === true
    }

    "file task1.csv.gz contains expected data" in {
      withGZIPFile(outFilePathTask1, _.contains("ROW 89") === true)
    }

    "file task2.csv.gz contains expected data" in {
      withGZIPFile(outFilePathTask2, _.contains("ORD -32") === true)
    }

    "file task3.csv.gz contains expected data" in {
      withGZIPFile(outFilePathTask3, lines => (lines.contains("W2") && lines.contains("\tSLC 1888")) === true)
    }
  }
}