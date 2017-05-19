package loadSave

import com.twitter.elephantbird.mapreduce.output.LzoProtobufBlockOutputFormat
import org.apache.hadoop.mapreduce.Job

/**
  * BirdProtocol:
  * author: Chengjs, version:1.0.0, 2017-05-08
  */
object BirdProtocol {
  val job = new Job()
  val conf = job.getConfiguration
}



