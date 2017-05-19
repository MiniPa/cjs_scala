package grammar

/**
  * closure: 闭包
  * author: Chengjs, version:1.0.0, 2017-05-06
  */
object Closure {
  def main(args: Array[String]): Unit = {
    println("multiple(2) : " + multiple(2))
  }

  var factor = 3
  val multiple = (i:Int) => i*factor
}
