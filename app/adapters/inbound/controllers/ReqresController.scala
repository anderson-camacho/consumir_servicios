package adapters.inbound.controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.{Json, Writes}
import domain.model.User
import domain.services.ReqresServices.getAllUsers

class ReqresController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getAllUsersAction: Action[AnyContent] = Action { implicit request =>
    val allUsers = getAllUsers
    Ok(Json.toJson(allUsers))
  }
}
