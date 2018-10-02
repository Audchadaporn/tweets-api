package server.handler

import com.google.inject.{Inject, Singleton}
import server.Service.ShoutService
import server.message.{ShoutTweetsRequest, ShoutTweetsResponse}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait ShoutHandler {
  def tweets(request: ShoutTweetsRequest): Future[ShoutTweetsResponse]
}

@Singleton
class ShoutHandlerImpl @Inject()(shoutService: ShoutService)
    extends ShoutHandler {

  override def tweets(
      request: ShoutTweetsRequest): Future[ShoutTweetsResponse] = {
    shoutService
      .getShoutTweets(request.username, request.numberOfTweets)
      .map(
        tweets =>
          ShoutTweetsResponse(
            success = tweets.nonEmpty,
            tweets = tweets
        ))
      .recover {
        case error: Throwable =>
          ShoutTweetsResponse(success = false,
                              errorMessage = Some(error.getMessage),
                              tweets = Vector.empty)
      }
  }
}
