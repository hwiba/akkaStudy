package next.race;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class MoveActor extends UntypedActor {
	private final ActorRef randomActor;

	public MoveActor(ActorRef randomActor) {
		this.randomActor = randomActor;
	}
	
	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof RaceStartMessage) {
			System.out.println("move");
			int[] intArray = {1, 1, 1};
			randomActor.tell(new RandomMessage(5, intArray), getSelf());
        }
	}
}
