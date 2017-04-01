package ly01;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of a Grass
 * 
 * @author mboullouz
 *
 */
public class Grid {

	private List<Cell> cells;

	private int maxX;
	private int maxY;

	public Grid() {
		super();
		this.cells = new ArrayList<Cell>();
	}

	public Grid(int dimX, int dimY) {
		this();
		this.maxX = dimX;
		this.maxY = dimY;
		this.generateCells();
	}

	public Grid(String dimsCommand) {
		this(   
				Integer.valueOf(Helper.InstructionParser.initialization(dimsCommand)[0]),
				Integer.valueOf(Helper.InstructionParser.initialization(dimsCommand)[1])
			);
	}

	/**
	 * Fill the grid with cells
	 */
	private void generateCells() {
		this.cells = new ArrayList<Cell>();
		for (int i = 0; i <= this.maxX; i++) {
			for (int j = 0; j <= this.maxY; j++) {
				Cell cell = new Cell(i, j);
				this.cells.add(cell);
			}
		}

	}

	/**
	 * Get a cell by its coordinate, return null if not found
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Cell getCell(int x, int y) {
		/* Don't loop if coordinate are invalid */
		if (x < 0 || y < 0 || x > this.maxX || y > this.maxY) {
			return null;
		}
		for (Cell c : this.cells)
			if (c.getX() == x && c.getY() == y) {
				return c;
			}
		return null;
	}

	/**
	 * Check if a mower can move to a cell identified by its coordinate (x,y)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canMoveToCellAt(int x, int y) {
		if (x < 0 || y < 0 || x > this.maxX || y > this.maxY || this.getCell(x, y) == null || this.getCell(x, y).isOccupied()) {
			return false;
		}
		return true;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

}
