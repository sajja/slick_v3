package basic

import domain.Accounts
import slick.lifted.TableQuery

import scala.concurrent.Await
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.duration.Duration

object TestMe {
  def main(args: Array[String]): Unit = {
    val accountTable = TableQuery[Accounts]
    println("xxxxxxxxxxxxxxxxxxx")
    val db = Database.forConfig("pg")
    val i = accountTable.schema.create
    Await.result(db.run(i),Duration.Inf)
  }
}
