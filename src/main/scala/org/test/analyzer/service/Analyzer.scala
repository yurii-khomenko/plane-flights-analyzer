package org.test.analyzer.service

import org.test.analyzer.model.LogRecord

object Analyzer {

  def origins(records: List[LogRecord]): Map[String, Int] = records
    .groupBy(_.origin)
    .mapValues(_.size)

  def destinations(records: List[LogRecord]): Map[String, Int] = records
    .groupBy(_.destination)
    .mapValues(_.size)

  def diff(origins: Map[String, Int], destinations: Map[String, Int]): Map[String, Int] = origins
    .map(o => (o._1, o._2 - destinations(o._1)))
    .filter(_._2 != 0)

  def destinationsWeeks(records: List[LogRecord]): Map[Int, Map[String, Int]] = records
    .groupBy(_.week)
    .mapValues(_.groupBy(_.destination)
      .mapValues(_.size))
}
