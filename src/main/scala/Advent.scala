import scala.collection.mutable
import scala.io.Source

object Advent {

  def main(args: Array[String]): Unit = {
    println(s"Result 1.1 : $exercise11")
    println(s"Result 1.2 : $exercise12")

    println(s"Result 2.1 : $exercise21")
  }

  def exercise11(): Int ={
    lazy val in = Source.fromURL(getClass.getResource(s"/ex11.txt")).getLines().toList
    in.map(_.toInt).sum
  }

  def exercise12(): Int ={
    lazy val in = Source.fromURL(getClass.getResource(s"/ex12.txt"))
      .getLines()
      .map(_.toInt)
      .toStream

    val stream = Iterator.continually(in).flatten.scanLeft(0)(_ + _)
    val res = mutable.Set[Int]()
    var ft :Option[Int] = None

    do {
      val elem = stream.next
      if(!res.add(elem)){
        ft = Some(elem)
      }
    } while (ft.isEmpty)

    ft.get
  }

  def exercise21(): Int ={

    implicit def toInt(b: Boolean): Int = if (b) 1 else 0

    lazy val in = Source.fromURL(getClass.getResource(s"/ex21.txt")).getLines().toList
    val tmp = in.map(_.groupBy(identity).mapValues(_.size).values.toSeq)
    val (sumNb2, sumNb3) = tmp.foldLeft(0, 0){
      case ((nb2, nb3), e) => (nb2 + e.contains(2), nb3 + e.contains(3))
    }
    sumNb2 * sumNb3
  }

}
