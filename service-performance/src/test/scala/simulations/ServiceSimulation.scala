package simulations

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.core.config.GatlingConfiguration.configuration
import io.gatling.http.Predef._
import io.gatling.http.util.HttpHelper.OkCodes

import scala.concurrent.duration._

class ServiceSimulation extends Simulation {

  private val appConfig = ConfigFactory.load()
  private val host = appConfig.getString("service.host")
  private val requestCount = appConfig.getInt("scenario.requestCount")
  private val duration = appConfig.getDuration("scenario.duration", MINUTES)
  private val percentile99ResponseTime = appConfig.getDuration("scenario.percentile99ResponseTime", MILLISECONDS)

  val userAgent = s"Gatling/${configuration.core.version}"
  val httpConf = http
    .acceptHeader("*/*")
    .connection("Keep-Alive")
    .userAgentHeader(userAgent)
    .disableCaching
    .disableWarmUp
    .disableAutoReferer
    .disableClientSharing

  println("--- Configuration for current test run : ---")
  println("HOST_NAME : " + host)
  println("REQUEST_COUNT : " + requestCount)


  def getPersonScenario = scenario("Get person scenario")
    .exec(http("Get unknown person")
      .get("/api/person/")
      .check(
        status.in(OkCodes)
      )
    )

  setUp(
    getPersonScenario.inject(constantUsersPerSec(requestCount) during duration.minutes).protocols(httpConf.baseURL(host)))
    .assertions(
      global.responseTime.percentile4.lessThan(percentile99ResponseTime.toInt)
  )
}
