import scala.io.Source

object Advent {

  def main(args: Array[String]): Unit = {
    println(s"Result 1.1 : $exercise11")
  }

  def exercise11(): Int ={
    val in = Source.fromURL(getClass.getResource(s"/ex11.txt")).getLines().toList
    in.map(_.toInt).sum
  }

  def exercise12(): Int ={
    val in = Source.fromURL(getClass.getResource(s"/ex12.txt")).getLines().toList
    val res = Set[Int]()
    while (true){
      
    }
    in.head
  }

}
