package org.test.analyzer.model

import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import scala.io.Source

case class LogRecord(flDate: Date, week: Int, origin: String, destination: String)

object LogRecord {

  val flDateIndex = 5
  val originIndex = 6
  val destinationIndex = 7

  val formatter = new SimpleDateFormat("yyyy-MM-dd")
  val cal = Calendar.getInstance

  def toDate(str: String) = formatter.parse(str)

  def toWeek(date: Date) = {
    cal.setTime(date)
    cal.get(Calendar.WEEK_OF_YEAR)
  }

  def truncQuotes(str: String) = str.substring(1, str.length - 1)

  def apply(line: String): LogRecord = {

    val splitLine = line.split(",")

    val flDate = toDate(splitLine(flDateIndex))
    val week = toWeek(flDate)
    val origin = truncQuotes(splitLine(originIndex))
    val destination = truncQuotes(splitLine(destinationIndex))

    new LogRecord(flDate, week, origin, destination)
  }

  def apply(in: InputStream): List[LogRecord] =
    Source.fromInputStream(in).getLines().drop(1)
      .map(LogRecord(_)).toList
}