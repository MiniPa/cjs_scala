package loadSave

import com.twitter.elephantbird.mapreduce.input.LzoJsonInputFormat
import org.apache.hadoop.io.{LongWritable, MapWritable, Text}
import org.apache.hadoop.mapred.KeyValueTextInputFormat
import org.apache.spark.{SparkConf, SparkContext}

/**
  * InOutFormat:
  * author: Chengjs, version:1.0.0, 2017-05-08
  */
object InOutFormat {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("localhost").setAppName("InOutFormat")
    val sc = new SparkContext(conf)

    // 1.simplest hadoop input format
    val input1 = sc.hadoopFile[Text,Text,KeyValueTextInputFormat]("inputFile").map{
      case(x,y) => (x.toString, y.toString)
    }
    // 2.elephant bird of twitter supporting data formats
//    val inputJson = sc.newAPIHadoopFile("jsonInputHadoopFile",
//      classOf[LzoJsonInputFormat],classOf[LongWritable],classOf[MapWritable],conf) //why?
  }
}
