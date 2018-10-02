package server.proxy

import akka.actor.ActorSystem
import com.google.inject.{Inject, Singleton}
import org.joda.time.DateTime
import server.models.Tweet

import scala.concurrent.Future

trait TwitterProxy {
  def getStatusesUserTimeline(screenName: String, count: Int): Future[Vector[Tweet]]
}

@Singleton
class TwitterProxyImpl @Inject()(actorSystem: ActorSystem) extends TwitterProxy {

  override def getStatusesUserTimeline(screenName: String, count: Int): Future[Vector[Tweet]] =
    //TODO: Remove mocked data and Call to Twitter API's /1.1/statuses/user_timeline
    //TODO: Twitter4J lib, TimelinesResourcesAsync.getUserTimeline(java.lang.String screenName, Paging paging)
    Future.successful(Vector(
      Tweet(1, DateTime.now, "My first tweet", None),
      Tweet(2, DateTime.parse("2018-05-06"), "My second tweet", None)
    ))

}