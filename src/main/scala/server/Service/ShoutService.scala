package server.Service

import com.google.inject.{Inject, Singleton}
import server.models.Tweet
import server.repository.ShoutRepository

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait ShoutService {
  def getShoutTweets(userName: String, count: Int): Future[Vector[Tweet]]
}

@Singleton
class ShoutServiceImpl @Inject()(shoutRepository: ShoutRepository) extends ShoutService {

  override def getShoutTweets(userName: String, count: Int): Future[Vector[Tweet]] =
    shoutRepository.getShoutTweets(userName, count).map{tweets =>
      tweets.map{tweet =>
        tweet.copy(text = tweet.text.toUpperCase.concat("!"))
      }
    }

}
