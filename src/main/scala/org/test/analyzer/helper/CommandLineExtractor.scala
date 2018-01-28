package org.test.analyzer.helper

import org.test.analyzer.helper.CommonHelper._

object CommandLineExtractor {

  def unapplySeq(args: Array[String]): Option[Seq[String]] = {

    if (args.length < 1) printInfoAndExit()
    val task = args(0).trim

    Some(Seq(task))
  }
}