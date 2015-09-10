package next.race;

public class DrawMessage {
	int[][] array;
	
	public DrawMessage(int[][] array) {
		this.array = array;
	}
	
	public String draw() {
		//TODO '-'로 갯수 출력
		return String.valueOf(array);
	}
}
