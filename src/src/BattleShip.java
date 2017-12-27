package src;
import java.util.Arrays;

public class BattleShip {
	public static void main(String[] args) {
		//Object[] sub1 = new Object[]{1,1,3,"right","Sub"};
		ShipParms[] ships = new ShipParms[]{
				new ShipParms(0,0,3,"right","Sub"),
				new ShipParms(0,1,3,"right","Sub"),
				new ShipParms(1,2,6,"up","Sub")
				};
		Board board1 = new Board("1", ships);
		for(int i=0;i<12;i++) {
				System.out.println(Arrays.toString(board1.getGrid()[i]));
	}
		int[] coords = new int[]{1,1};
		System.out.println(board1.checkSquare(coords));
	}
}
