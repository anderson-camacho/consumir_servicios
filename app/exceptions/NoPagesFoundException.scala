package exceptions

case class NoPagesFoundException(message: String) extends Exception(message)
