package v1.post

import scalikejdbc._

/**
  * Created by kitazawa-yoshi on 2017/08/02.
  * 下記のページを参考に構築　
  * http://qiita.com/suin/items/279ea03af5c2745e5e7a
  */

case class User(id: String, name: String)

object User extends SQLSyntaxSupport[User] {
  override val tableName = "user"

  def apply(rs: WrappedResultSet): User = User(rs.string("id"), rs.string("name"))

  def apply(u: ResultName[User])(rs: WrappedResultSet): User = User(rs.string(u.id), rs.string(u.name))
}