package next.race;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class RandomActor extends UntypedActor {
	
	private final ActorRef drawActor;

	public RandomActor(ActorRef drawActor) {
		this.drawActor = drawActor;
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof RandomMessage) {
			System.out.println("random");
			int[][] array = move((RandomMessage) message);
			drawActor.tell(new DrawMessage(array), getSelf());
        }
	}
	
	private int[][] move (RandomMessage message) {
		// TODO 재귀로 반복.
		return null;
	}

}
