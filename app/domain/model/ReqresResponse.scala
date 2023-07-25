package domain.model

case class ReqresResponse( //General Schema for get request
                           page: Int,
                           per_page: Int,
                           total: Int,
                           total_pages: Int,
                           data: List[User],
                           support: Support
                   )
