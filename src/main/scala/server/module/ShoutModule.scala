package server.module

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.{ScalaModule, ScalaMultibinder}
import server.Service.{ShoutService, ShoutServiceImpl}
import server.handler.{ShoutHandler, ShoutHandlerImpl}
import server.proxy.{TwitterProxy, TwitterProxyImpl}
import server.repository.{ShoutRepository, ShoutRepositoryImpl}
import server.route.{ShoutRoutes, ShoutRoutesImpl}

class ShoutModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {

//    val multipleRoutes = ScalaMultibinder.newSetBinder[ShoutRoutes](binder)
//    multipleRoutes.addBinding.to[ShoutRoutesImpl]

    bind[ShoutRoutes].to[ShoutRoutesImpl]
    bind[ShoutHandler].to[ShoutHandlerImpl]
    bind[ShoutService].to[ShoutServiceImpl]
    bind[ShoutRepository].to[ShoutRepositoryImpl]
    bind[TwitterProxy].to[TwitterProxyImpl]

  }
}
