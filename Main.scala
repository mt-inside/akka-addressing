import akka.actor._

object Main extends App
{
  val system = ActorSystem("akka-addressing")
  val s = system.actorOf(Server.props, "service")
  val c = system.actorOf(Client.props, "client-uuid")
  c ! Client.DoWork
}
