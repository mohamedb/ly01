package ly01;

/**
 * 
 * @author mboullouz
 *
 */
public class Cell {
	private int x;
	private int y;
	
	private boolean occupied =false;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
