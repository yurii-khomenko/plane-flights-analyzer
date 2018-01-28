package org.test.analyzer.service

import org.test.analyzer.helper.CommonHelper.withFiles
import org.test.analyzer.model.LogRecord
import org.test.analyzer.service.Analyzer.{destinations, destinationsWeeks, diff, origins}

object Tasks {

  def task1(inFileName: String, outFileName: String): Unit =
    withFiles(inFileName, outFileName, (in, out) => {
      val records = LogRecord(in)
      destinations(records) foreach { case (k, v) => out.println(s"$k $v") }
    })

  def task2(inFileName: String, outFileName: String): Unit =
    withFiles(inFileName, outFileName, (in, out) => {
      val records = LogRecord(in)
      val origin = origins(records)
      val dest = destinations(records)
      diff(origin, dest) foreach { case (k, v) => out.println(f"$k $v%+d") }
    })

  def task3(inFileName: String, outFileName: String): Unit =
    withFiles(inFileName, outFileName, (in, out) => {
      val records = LogRecord(in)
      destinationsWeeks(records).toSeq.sortBy(_._1) foreach {
        case (idx, map) =>
          out.println(s"W$idx")
          map foreach { case (k, v) => out.println(s"\t$k $v") }
      }
    })
}