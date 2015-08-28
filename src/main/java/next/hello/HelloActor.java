package next.hello;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof HelloMessage) {
            System.out.println("My message is : " + ((HelloMessage) message).getMessage());
        }
    }

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("MySystem");
        ActorRef actorRef = actorSystem.actorOf(Props.create(HelloActor.class), "myActor");
        actorRef.tell(new HelloMessage("Hello, Akka!"), ActorRef.noSender());

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        actorSystem.stop(actorRef);
        actorSystem.shutdown();
    }
}
