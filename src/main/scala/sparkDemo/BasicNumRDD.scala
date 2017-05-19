package sparkDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * BasicNumRDD:
  * author: Chengjs, version:1.0.0, 2017-05-06
  */
object BasicNumRDD {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("BasicNumRDD"))
    val inputNumPair = sc.textFile("inputNum.txt").map(line => (line.split(" ")(0),line.split(" ")(1)))

    //1.
    val pairs1 = inputNumPair.reduceByKey( (x,y) => (x + y) )

    //2.
    val numSumPair = inputNumPair.mapValues(v => (v, 1))
                      .reduceByKey( (x,y) => (x._1+ y._1, x._2 + y._2) )
    val pairs = inputNumPair.filter{case (key, value) => Integer.parseInt(value) < 400}


  }
}
