package pool

import com.pagero.slick.driver.api._
import com.pagero.slick._
import domain.Accounts

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object Pagero {
  def main(args: Array[String]): Unit = {
    val accountTable = TableQuery[Accounts]
    val loop = 1 to 2
    val r = loop.map {
      i =>
        println("running....")
        db.run(accountTable.result)
    }
    import scala.concurrent.ExecutionContext.Implicits.global
    Await.result(Future.sequence(r), Duration.Inf)

    Thread.sleep(10000)
  }
}
