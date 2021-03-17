package pool

import com.mchange.v2.c3p0.ComboPooledDataSource
import domain.{Account, Accounts}
import slick.jdbc.PostgresProfile.api._
import slick.lifted.TableQuery

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object PoolExample {

  def ds() = {
    val ds = new ComboPooledDataSource
    ds.setDriverClass("org.postgresql.ds.PGSimpleDataSource")
    ds.setJdbcUrl("jdbc:postgresql:sajith")
    ds.setUser("postgres")
    ds.setPassword("postgres")
    ds.setTestConnectionOnCheckout(true)
    ds.setTestConnectionOnCheckin(true)
    ds
  }


//  def testTooManyConnection

  def main(args: Array[String]): Unit = {
    val accountTable = TableQuery[Accounts]
    val db = Database.forDataSource(ds(),None)
    val loop = 1 to 20000
    val r = loop.map {
      i =>
        db.run(accountTable.result)
    }
    import scala.concurrent.ExecutionContext.Implicits.global
    Await.result(Future.sequence(r), Duration.Inf)

    Thread.sleep(10000)
    //    val i = accountTable.schema.drop
    //    val i = accountTable.schema.create
    //    Await.result(db.run(i),Duration.Inf)
  }

}
