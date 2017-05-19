package loadSave

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Hive:
  * author: Chengjs, version:1.0.0, 2017-05-08
  */
class Hive {
  val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("TextInput"))

  val hiveCtx = new HiveContext(sc)
  val rows = hiveCtx.sql(sqlText = "SELECT name, age FROM users")

  val firstRow = rows.first()
  println(firstRow.getString(0)) // Field 0 is name

  // JSON loading with spark SQL
//  val tweets = hiveCtx.jsonFile("tweets.json")
//  tweets.registerTemplate("tweets")
//  val reuslt = hiveCtx.sql("SELECT name, age FROM users")
}
