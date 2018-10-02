package server.route

import akka.http.scaladsl.server.{Directives, Route}
import com.google.inject.Inject
import javax.inject.Singleton
import server.handler.ShoutHandler
import server.message.ShoutTweetsRequest

trait ShoutRoutes {
  def routes: Route
}

@Singleton
class ShoutRoutesImpl @Inject()(shoutHandler: ShoutHandler) extends ShoutRoutes with Directives with JsonSupport {

  def tweets: Route = path("v1" / "shout" / "tweets") {
    pathEndOrSingleSlash {
      get {
        entity(as[ShoutTweetsRequest]) { request =>
          complete(
            shoutHandler.tweets(request)
          )
        }
      }
    }
  }

  val routes: Route = tweets
}
