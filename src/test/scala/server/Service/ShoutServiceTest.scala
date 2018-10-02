package server.Service

import org.joda.time.DateTime
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.scalatest.{AsyncFunSuite, BeforeAndAfter}
import org.scalatest.mockito.MockitoSugar
import server.models.Tweet
import server.repository.ShoutRepository

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class ShoutServiceTest extends AsyncFunSuite with MockitoSugar {

  val mockShoutRepository = mock[ShoutRepository]

  val tweet1 = Tweet(1, DateTime.parse("2018-09-27"), "My first tweet", None)

  test("getShoutTweets") {
    when(mockShoutRepository.getShoutTweets("twitterAcc", 1)).thenReturn(Future.successful(Vector(tweet1)))

    val expectedTweet = tweet1.copy(text = "MY FIRST TWEET!")

    val service = new ShoutServiceImpl(mockShoutRepository)

    val result = Await.result(service.getShoutTweets("twitterAcc", 1), 1.second)
    assert(result.nonEmpty)
    assert(result.filter(_.id == 1).head == expectedTweet)
  }

}
