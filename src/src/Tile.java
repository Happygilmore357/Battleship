package src;

public class Tile {
	
	private int score;
	private Tile[] neighbors = new Tile[4];
	private int publicValue;
	
	public Tile() {}
	
	public int getScore() {
		score = 0;
		
		for (Tile tile : neighbors) {
			score += tile.getPublicValue();
		}
		
		return score;
	}

	public int getPublicValue() {
		return publicValue;
	}


	
}
