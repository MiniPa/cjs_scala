package sparkDemo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * PageRank: document 权重计算
  * author: Chengjs, version:1.0.0, 2017-05-07
  */
object PageRank {

  val sc = new SparkContext(new SparkConf().setMaster("localhost").setAppName("PageRank"))

  val links = sc.objectFile[(String,Seq[String])]("links") // (pageId, linkList)
  var ranks = links.mapValues(v => 1.0) // (pageId, rank)
  for( i <- 0 until 10 ) {
    val contributions = links.join(ranks).flatMap {
      case (pageId, (links, rank)) => links.map(dest => (dest, rank/links.size))
    }
    ranks = contributions.reduceByKey((x, y) => x + y).mapValues(v => 0.15 + 0.85*v)
  }
  ranks.saveAsTextFile("ranks")
}



