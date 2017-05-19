package sparkDemo

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.I
import org.apache.spark.{SparkConf, SparkContext}

/**
  * BasicTextRDD:
  *
  * author: Chengjs, version:1.0.0, 2017-05-05
  */
object BasicTextRDD {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster(master = "local").setAppName(name = "BasicTextRDD")
    val sc = new SparkContext(conf)

    // 1.create RDD
    val lines_2 = sc.parallelize(List("spark", "I like spark")) // create a RDD from an existing collection
    val lines = sc.textFile("input.txt") // commony way to create a RDD from data
    // 2.transformation
    val errorsRDD = lines.filter(line => line.contains("error"))
    val warningsRDD = lines.filter(line => line.contains("warning"))
    val badRDD = errorsRDD ++ warningsRDD
    // 3.actions
    val badNums = badRDD.count();  println(x = badNums)
    print("here are three badNums: "); badRDD.take(3).foreach(println)
    val errorStr = errorsRDD.collect().mkString(",")

    val words = lines.flatMap(line => line.split(" "))
    val firstWord = words.first(); println("firstWord:" + firstWord)

  }

}
