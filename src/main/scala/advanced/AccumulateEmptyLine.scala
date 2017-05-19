package advanced

import org.apache.spark.{SparkConf, SparkContext}

/**
  * AccumulateEmptyLine:
  * author: Chengjs, version:1.0.0, 2017-05-08
  */
object AccumulateEmptyLine {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("AccumulateEmptyLine"))

    val file = sc.textFile("file.txt")
    val blanklines = sc.accumulator(0)
    val callSings = file.flatMap(line => {
      if(line == "") {
        blanklines += 1
      }
      line.split(" ")
    })

    callSings.saveAsTextFile("AccumulateEmptyLineOutput.txt")
    println("Blank lines: " + blanklines.value)

  }
}
