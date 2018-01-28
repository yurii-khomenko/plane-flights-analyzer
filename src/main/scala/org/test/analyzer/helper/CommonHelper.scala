package org.test.analyzer.helper

import java.io._
import java.util.zip.{GZIPInputStream, GZIPOutputStream}

object CommonHelper {

  def withFiles(inFilePath: String, outFilePath: String, op: (InputStream, PrintWriter) => Unit): Unit = {
    val in = new GZIPInputStream(new FileInputStream(inFilePath))
    val out = new PrintWriter(new GZIPOutputStream(new FileOutputStream(outFilePath)))
    try { op(in, out) } finally { try { in.close() } finally out.close() }
  }

  def prepaireToStore(difference: Map[String, Int]): Seq[((String, Int), Int)] = difference.zipWithIndex.toSeq.sortBy(_._2)

  def currentTime = System.nanoTime()
  def currentHeap = Runtime.getRuntime.totalMemory() - Runtime.getRuntime.freeMemory()
  def toMs(nanoseconds: Long) = nanoseconds / 1000000
  def toMb(bytes: Long) = bytes / 1048576

  def printInfoAndExit() {
    println("\nPlease type task number:" +
      "\n" +
      "tasks:\n" +
      "\t 1) List of all airports with total number of planes for the whole period that arrived to each airport\n" +
      "\t 2) Non-Zero difference in total number of planes that arrived to and left from the airport\n" +
      "\t 3) Do the point 1 but sum number of planes separately per each week\n")
    System.exit(1)
  }

  def printUnknownTaskAndExit() { println("Unknown task number, please type action from 1 to 3"); System.exit(2) }

  def printCheckPath(path: String) = println("\nCompleted! Please check path \'" + path + '\'')

  def printMemoryConsumed(startMem: Long) = println(s"\nMemory consumed: ${toMb(currentHeap - startMem)}mb.")

  def printSpentTime(startTime: Long) = println(s"Spent time: ${toMs(currentTime - startTime)}ms.")
}