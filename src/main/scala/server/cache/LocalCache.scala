package server.cache

import com.google.common.cache.CacheBuilder
import scalacache.{ScalaCache, _}
import scalacache.guava._

trait LocalCache {

  def cacheMaximumSize: Option[Int]

  implicit val scalaCache = cacheMaximumSize match {
    case Some(size) => ScalaCache(GuavaCache.apply(CacheBuilder.newBuilder().maximumSize(size).build[String, Object]()))
    case None       => ScalaCache(GuavaCache())
  }
}