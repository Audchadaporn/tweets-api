package server.models

import models.ImageUrl
import org.joda.time.DateTime

final case class Tweet(id: Int, time: DateTime, text: String, image: Option[ImageUrl])

