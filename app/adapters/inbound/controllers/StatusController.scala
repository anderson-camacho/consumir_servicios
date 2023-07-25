package adapters.inbound.controllers

import javax.inject._
import play.api.mvc._
import domain.services.AnswerHttpServices

class StatusController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def success: Action[AnyContent] = Action { implicit request =>
    Ok(AnswerHttpServices.getResponseOk())
  }

  def noContent: Action[AnyContent] = Action { implicit request =>
    NoContent
  }

  def badRequest: Action[AnyContent] = Action { implicit request =>
    BadRequest(AnswerHttpServices.getResponseBadRequest())
  }

  def unauthorized: Action[AnyContent] = Action { implicit request =>
    Unauthorized(AnswerHttpServices.getResponseUnauthorized())
  }

  def internalServerError: Action[AnyContent] = Action { implicit request =>
    InternalServerError(AnswerHttpServices.getResponseInternalServerError())
  }
}
