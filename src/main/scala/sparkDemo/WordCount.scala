package sparkDemo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import util.EnvVarUtil

import scala.util.Properties

/**
  * WordCount:
  *
  * author: Chengjs, version:1.0.0, 2017-05-03
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)

//    val input: RDD[String] = sc.textFile(inputFile.txt)
//    val words = input.flatMap(line => line.split(" "))
//    val counts = words.map(word => (word,1)).reduceByKey{case (x,y) => x + y)}
    val basePath = EnvVarUtil.getClassRelativePath;
    val test : RDD[String] = sc.textFile("input.txt")
    test.flatMap(line => line.split("")).map(word => (word,1)).reduceByKey(_+_).saveAsTextFile("output")
    sc.stop
  }
}

