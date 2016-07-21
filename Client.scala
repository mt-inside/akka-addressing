import akka.actor._
import akka.pattern.ask

object Client
{
  def props = Props[Client]

  /* Input */
  case object DoWork

  /* Output */
  case class Result(x: Int)
}

class Client extends Actor with ActorLogging
{
  import Client._

  //val service = context.actorFor("/user/service")
  val service = context.actorSelection("/user/service")
  //val service = context.actorFor("/user/wrong")
  //val service = context.actorSelection("/user/wrong")

  def receive =
  {
    case DoWork => service ! Server.Serve
    case Server.Served(x) =>
    {
      log.warning(s"Result: $x")
      context.system.shutdown
    }

    case x => log.info("got msg " + x)
  }
}
