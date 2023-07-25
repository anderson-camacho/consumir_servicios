package exceptions

case class NoValidPagesFoundException(message: String) extends Exception(message)
