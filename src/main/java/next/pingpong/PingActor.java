package next.pingpong;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class PingActor extends UntypedActor {
    private final ActorRef pongActor;

    private int count = 0;

    private void incrementAndPrint() {
        count += 1;
        System.out.println("ping : count = " + count);
    }

    public PingActor(ActorRef pongActor) {
        this.pongActor = pongActor;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof StartMessage) {
            incrementAndPrint();
            pongActor.tell(new PingMessage(), getSelf());
        } else if (message instanceof  PongMessage) {
            incrementAndPrint();
            if (count > 99) {
                pongActor.tell(new StopMessage(), getSelf());
                System.out.println("ping stopped");
                getContext().stop(getSelf());
            } else {
                pongActor.tell(new PingMessage(), getSelf());
            }
        }
    }
}
