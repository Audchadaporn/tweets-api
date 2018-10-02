package server.message

import server.models.Tweet

final case class ShoutTweetsResponse(
    success: Boolean,
    errorMessage: Option[String] = None,
    tweets: Vector[Tweet] = Vector.empty[Tweet])
