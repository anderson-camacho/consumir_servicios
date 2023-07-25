package domain.utils

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import config.ConstantsReqres.URI_REQRES
import exceptions.NotFoundException
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

import java.net.MalformedURLException

// Constants
import config.ConstantsReqres.URI_REQRES

class UtilHttpSpec extends AnyFlatSpec with Matchers {

  "UtilHttp" should "return a non-empty response for a valid request" in {
    // Given
    val baseURL = URI_REQRES
    val page = 1

    // When
    val response = UtilHttp.makeRequest(baseURL, page)

    // Then
    response.statusCode mustBe 200
  }

  "throw" should "NotFoundException when the response data is empty" in {
    // Given
    val baseURL = URI_REQRES
    val page = 3 // Assuming page 2 returns empty data for the purpose of this test

    // When & Then
    val exception = intercept[MalformedURLException] {
      UtilHttp.makeRequest(baseURL, page)
    }

    exception.getMessage mustBe "No se encontro ningun dato"
  }
}
