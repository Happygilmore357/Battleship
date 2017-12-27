package src;
import java.util.Arrays;


public class Ship {
	//private String[] shipNames = {"Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier"};
	public boolean sunk = false;
	private int[] origin = new int[2];
	private int size;
	private String direction;
	private int[][] coords;
	private String name;
	
	

	
	public Ship(ShipParms parms) {// xCoord, yCoord, size, direction, name {
		this.origin[0] = parms.x+1;
		this.origin[1] = 10-parms.y;
		this.size = parms.size;
		this.direction = parms.direction;
		this.coords = new int[size][2];
		this.name = parms.name;
		switch (this.direction) {
			case "right": this.coords = genCoords(1,0,size);
				break;
			case "left" : this.coords = genCoords(-1,0,size);
				break;
			case "up" : this.coords = genCoords(0,1,size);
				break;
			default : this.coords = genCoords(0,-1,size);
				break;
		}
	}
	
	private int[][] genCoords(int x,int y, int size) {
		
		int[][] coords = new int[size][2];
		coords[0] = this.origin;
		for (int i=1; i<size; i++) {
			coords[i][0] = coords[i-1][0]+x;
			coords[i][1] = coords[i-1][1]-y;
		}
		return coords;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int[][] getCoords() {
		return this.coords;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}
	
	public boolean getSunk() {
		return sunk;
	}
	
}
