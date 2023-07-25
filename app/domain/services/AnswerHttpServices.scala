package domain.services

import play.api.libs.json._

object  AnswerHttpServices {

  def getResponseOk(): JsObject = {
    val jsonResponse = Json.obj(
      "status" -> "OK",
      "message" -> "Successful answer",
      "description"-> "You got this answer because this place is being built"
    )
    jsonResponse
  }

  def getResponseBadRequest(): JsObject = {
    val jsonResponse = Json.obj(
      "status" -> "BAD REQUEST",
      "message" -> "Bad Request answer",
      "description" -> "You got this answer because this place is wrong"
    )
    jsonResponse
  }

  def getResponseUnauthorized(): JsObject = {
    val jsonResponse = Json.obj(
      "status" -> "Unauthorized",
      "message" -> "Unauthorized for this page",
      "description" -> "You got this answer because this place is no unauthorized"
    )
    jsonResponse
  }

  def getResponseInternalServerError(): JsObject = {
    val jsonResponse = Json.obj(
      "status" -> "Internal Server Error",
      "message" -> "Internal Server Error in this API",
      "description" -> "You got this answer because this place is down"
    )
    jsonResponse
  }
}
