package loadSave

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.spark.{SparkConf, SparkContext}

/**
  * JsonPerson:
  * author: Chengjs, version:1.0.0, 2017-05-07
  */
case class JsonPerson(name: String, lovePandas: Boolean) {
  val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("TextInput"))
  val inputJson = sc.textFile("pandaJson")
  val mapper = new ObjectMapper() // a json object jackson-databind
  val result = inputJson.flatMap(record => {
    try {
      Some(mapper.readValue(record, classOf[JsonPerson]))
    } catch {
      case e: Exception => None
    }
  }
  )
  result.filter(p => p.lovePandas).map(mapper.writeValueAsString(_)).saveAsTextFile("outputJson")
}
