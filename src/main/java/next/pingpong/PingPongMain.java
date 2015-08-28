package next.pingpong;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class PingPongMain {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("pingpong");
        ActorRef pongActor = actorSystem.actorOf(Props.create(PongActor.class), "pong");
        ActorRef pingActor = actorSystem.actorOf(Props.create(PingActor.class, pongActor), "ping");

        pingActor.tell(new StartMessage(), ActorRef.noSender());

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        actorSystem.shutdown();
    }
}
