package server.repository

import com.google.inject.{Inject, Singleton}
import scalacache.memoization.memoize
import server.cache.LocalCache
import server.models.Tweet
import server.proxy.TwitterProxy

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

trait ShoutRepository {
  def getShoutTweets(userName: String, count: Int): Future[Vector[Tweet]]
}

@Singleton
class ShoutRepositoryImpl @Inject()(twitterProxy: TwitterProxy) extends ShoutRepository with LocalCache{

  override def cacheMaximumSize = None

  override def getShoutTweets(userName: String, count: Int): Future[Vector[Tweet]] = memoize(45 second){
    twitterProxy.getStatusesUserTimeline(userName, count)
  }
}
