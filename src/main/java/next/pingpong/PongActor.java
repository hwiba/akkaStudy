package next.pingpong;

import akka.actor.UntypedActor;

public class PongActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PingMessage) {
            System.out.println("pong");
            getSender().tell(new PongMessage(), getSelf());
        } else if (message instanceof StopMessage) {
            System.out.println("pong stopped");
            getContext().stop(getSelf());
        }
    }
}
