package domain.model

import play.api.libs.json.Json

case class User(id: Int, email: String, first_name: String, last_name: String, avatar: String)

object User {implicit val userWrites = Json.format[User]}



