package loadSave

import java.io.StringReader

import au.com.bytecode.opencsv.CSVReader
import org.apache.spark.{SparkConf, SparkContext}

/**
  * CSV:
  * author: Chengjs, version:1.0.0, 2017-05-07p
  */
object CSV {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("CSV"))
    val input = sc.textFile("CSV.txt")

    val result = input.map{ line =>
      val reader = new CSVReader(new StringReader(line))
      reader.readNext()
    }

    result.collect()
  }

}
