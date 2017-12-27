package src;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {

	private int[][] grid = new int[12][12];		//0 = empty, 1 = ship, 2 = wall
	private String player;
	private ArrayList<Ship> ships = new ArrayList<Ship>(5);
	
	public Board(String player, ShipParms[] ships) {
		this.player = player;
		this.fillBoard();		
		this.createShips(ships);
		this.placeShips();
	}
					
	private void createShips(ShipParms[] ships) {
		for (int i=0; i<ships.length; i++) {
			Ship tempShip = new Ship(ships[i]);
			this.ships.add(tempShip);
		}
	}
			
	
	private void placeShips() {
		outerLoop:
		for (Ship ship : ships) {
			for (int j=0; j<ship.getSize(); j++) {
				int status = this.checkSquare(ship.getCoords()[j]);
				switch (status) {
				case 0 :
					this.grid[ship.getCoords()[j][1]][ship.getCoords()[j][0]] = 1;
					break;
				case 1: case 2: default:
					System.out.println("Invalid placement for ship: " + ship.getName());
					ship.setSunk(true);
					break outerLoop;
				}
			}
		}
	}
	
	private void fillBoard() {
		for (int x=0; x<12; x++) {
			for (int y=0; y<12; y++) {
				if (x==0 || x==11 || y==0 || y==11) {
					this.grid[y][x] = 2;
				} else {
					this.grid[y][x] = 0;
				}
			}
		}
	}
	
	public int checkSquare(int[] coords) {
		return this.grid[coords[1]][coords[0]];
	}

	public int[][] getGrid() {
		return grid;
	}
	
}
