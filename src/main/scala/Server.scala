import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import com.google.inject.Guice
import server.module.ShoutModule
import server.route.ShoutRoutes

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

object Server extends App with ShoutRoutes {

  val host = "localhost"
  val port = 8080

  var injector = Guice.createInjector(new ShoutModule())

  lazy val routes: Route = injector.getInstance(classOf[ShoutRoutes]).routes

  implicit val system: ActorSystem = ActorSystem("letshout")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

//  implicit val system: ActorSystem = injector.getInstance(classOf[ActorSystem])
//  implicit val executor: ExecutionContext = system.dispatcher
//  implicit val materializer: ActorMaterializer = injector.getInstance(classOf[ActorMaterializer])

  val serverBinding: Future[Http.ServerBinding] = Http().bindAndHandle(routes, "localhost", 8080)

  serverBinding.onComplete {
    case Success(bound) =>
      println(s"Server online at http://localhost:8080/")
    case Failure(e) =>
      Console.err.println(s"Server failed to start")
      e.printStackTrace()
      system.terminate()
  }

  Await.result(system.whenTerminated, Duration.Inf)

}
