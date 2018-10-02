package server.route

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import server.message.{ShoutTweetsRequest, ShoutTweetsResponse}
import server.models.Tweet
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport {
  import DefaultJsonProtocol._

  implicit val ShoutTweetsRequestJsonFormat = jsonFormat2(ShoutTweetsRequest)

  implicit val ShoutTweetsResponseJsonFormat = jsonFormat3(ShoutTweetsResponse)

}