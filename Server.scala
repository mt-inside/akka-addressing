import akka.actor._
import akka.actor.SupervisorStrategy._

object Server
{
  def props = Props[Server]

  /* input */
  case object Serve

  /* output */
  case class Served(x: Int)
}

class Server extends Actor with ActorLogging
{
  def receive =
  {
    case Server.Serve => {
      sender ! Server.Served(42)
    }
    case x => log.info("got msg " + x)
  }
}
