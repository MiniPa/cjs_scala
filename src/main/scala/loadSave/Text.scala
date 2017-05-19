package loadSave

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Text:
  * author: Chengjs, version:1.0.0, 2017-05-07
  */
object Text {
  val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("TextInput"))

  val input = sc.textFile("E:\\programers\\git_intellij\\chengjs-scala\\input\\input.txt")
  val input2 = sc.wholeTextFiles("E:\\programers\\git_intellij\\chengjs-scala\\input")

  // 1.text file
  val result = input.map(line => line.split(" "))

}
