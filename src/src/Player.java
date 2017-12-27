package src;

public class Player {

	private String name;
	private final Board board;

	public Player(String name, ShipParms[] ships) {
		this.name = name;
		this.board = new Board(this.name, ships);
	}
	
	public boolean fire(int x, int y) {
		//return true if hit
	}
	
}
