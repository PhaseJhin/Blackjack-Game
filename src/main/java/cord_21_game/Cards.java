package cord_21_game;

public class Cards {
	private String rank;
	private String point;
	public int score;
	
	
	public Cards(String rank, String point) {
		
		this.rank = rank;
		this.point = point;
		
		if (point == "J"||point == "Q"||point == "K") {
			this.score = 10;
		}
		else if (point == "A") {
			this.score = 1;
		}
		else {
			this.score = Integer.parseInt(point);
		}
	}
	
	public String getrank () {
		return rank;
	}
	
	public String getpoint() {
		return point;
	}
	
	public int getscore() {
		return score;
	}
	
	public void print() {
		System.out.print("rank"+rank);
		System.out.print("    point"+point);
		System.out.print("         score"+score);
	}
}
