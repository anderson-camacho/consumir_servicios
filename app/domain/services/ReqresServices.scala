package domain.services

import com.github.plokhotnyuk.jsoniter_scala.core.{JsonValueCodec, readFromArray}
import com.github.plokhotnyuk.jsoniter_scala.macros.{CodecMakerConfig, JsonCodecMaker}
import domain.utils.UtilHttp
import domain.model.User
import domain.model.ReqresResponse
import requests.Response
import exceptions.NotFoundException
import exceptions.NoPagesFoundException
import exceptions.NoValidPagesFoundException
import upickle.default._

//Constants
import config.ConstantsReqres.URI_REQRES

object ReqresServices {

  def getAllUsers: List[User] = {
    (1 to getTotalPageReqres(URI_REQRES, 1)).flatMap { page =>
      val data = Option(getDataReqres(URI_REQRES, page).data).getOrElse(List.empty[User])
      data
    }.toList
  }

  def getDataReqres(baseURL: String, page: Int): ReqresResponse = {
    implicit val reqResponsecodec: JsonValueCodec[ReqresResponse] = JsonCodecMaker.make(CodecMakerConfig)
    val data = readFromArray(UtilHttp.makeRequest(baseURL, page).bytes)
    println(s"Cosas: $data")
    try {
      if (data.data.isEmpty) {
        throw NotFoundException("No se encontraron datos a consultar")
      }
    } catch {
      case e: NotFoundException => println(e.message)
        return ReqresResponse(data.page, data.per_page, data.total, data.total_pages, null, null)
    }
    data
  }

  def getTotalPageReqres(baseURL: String, page: Int): Int = {
    implicit val reqResponsecodec: JsonValueCodec[ReqresResponse] = JsonCodecMaker.make(CodecMakerConfig)
    val answer: Response = UtilHttp.makeRequest(baseURL, page)
    val totalPages = readFromArray(answer.bytes).total_pages
    try {
      if (totalPages == 0) {
        throw NoPagesFoundException("Se encontraron 0 paginas")
      } else if (totalPages == null || totalPages.isNaN || totalPages.isInfinite) {
        throw NoValidPagesFoundException("no se encontraron paginas donde consultar")
      } else {
        println(s"la cantidad de paginas es: $totalPages")
      }
    } catch {
      case e: NoPagesFoundException => println(e.message)
      case e: NoValidPagesFoundException => println(e.message)
    }
    totalPages
  }
}