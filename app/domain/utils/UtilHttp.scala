package domain.utils

import requests.Response
import exceptions.NotFoundException

object UtilHttp {
  def makeRequest(baseURL: String, page: Int): Response = {
    val response = requests.get(s"$baseURL?page=$page")
    try {
      if (response.data.array.isEmpty) {
        throw NotFoundException("No se encontro ningun dato")
      }
    } catch {
      case e: NotFoundException => println(e.message)
    }
    response
  }
}
