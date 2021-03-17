package domain

import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag


case class Account(id: Long, name: Long)

class Accounts(tag: Tag) extends Table[Account](tag, "ACCOUNTS") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[Long]("NAME")
  def * = (id, name) <> (Account.tupled, Account.unapply)
}
