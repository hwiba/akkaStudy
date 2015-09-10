package next.race;

import akka.actor.UntypedActor;

public class DrawActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof DrawMessage) {
			System.out.println("Draw");
			System.out.println(((DrawMessage) message).draw());
        }
		
	}

}
