package org.test.analyzer.service

import java.io.FileInputStream
import java.util.zip.GZIPInputStream

import org.specs2.matcher.{MatchResult, TypedEqual}

import scala.io.Source

trait Helper {

  def withGZIPFile(name: String, op: Iterator[String] => MatchResult[Any]): MatchResult[Any] = {

    val in = new GZIPInputStream(new FileInputStream(name))

    try {
      val lines = Source.fromInputStream(in).getLines()
      op(lines)
    } finally {
      in.close()
    }
  }
}