package next.race;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class RaceMain {
	public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("racing");
        ActorRef drawActor = actorSystem.actorOf(Props.create(DrawActor.class), "draw");
        ActorRef randomActor = actorSystem.actorOf(Props.create(RandomActor.class, drawActor), "random");
        ActorRef moveActor = actorSystem.actorOf(Props.create(MoveActor.class, randomActor), "move");
        
        moveActor.tell(new RaceStartMessage(), ActorRef.noSender());

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        actorSystem.shutdown();
    }

}
