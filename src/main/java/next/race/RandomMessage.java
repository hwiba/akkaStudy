package next.race;

public class RandomMessage {
	
	private int step;
	private int[] intArray;
	
	public RandomMessage(int step, int[] intArray) {
		this.step = step;
		this.intArray = intArray;
	}
	
	public int getStep() {
		return this.step;
	}
	
	public int[] getIntArray() {
		return this.intArray;
	}
}
