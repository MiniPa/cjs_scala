package loadSave

import org.apache.hadoop.io.{IntWritable, Text}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * SequenceFile:
  * author: Chengjs, version:1.0.0, 2017-05-08
  */
object SequenceFile {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("SequenceFile"))

    val data1 = sc.sequenceFile("insequenceFile",classOf[Text],classOf[IntWritable])

    val data2 = sc.parallelize(List(("Panda",3),("Key",6),("Snail",2)))
    data2.saveAsSequenceFile("outsequenceFile")
  }
}
