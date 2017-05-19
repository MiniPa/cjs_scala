package loadSave

import java.sql.{DriverManager, ResultSet}

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.JdbcRDD

/**
  * jdbcLoad:
  * author: Chengjs, version:1.0.0, 2017-05-08
  */
object JdbcLoad {
  val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("TextInput"))
  def createConnection() = {
    Class.forName("com.mysql.jdbc.Driver").newInstance()
    DriverManager.getConnection("jdbc:mysql://localhost/test?user=holden")
  }
  def extractValues(r: ResultSet) = {
    (r.getInt(1), r.getString(2))
  }
  val data = new JdbcRDD(sc,createConnection,"SELECT * FROM panda WHERE ? <= id AND id <= ?",
    lowerBound = 1, upperBound = 3, numPartitions = 2, mapRow = extractValues)
}
