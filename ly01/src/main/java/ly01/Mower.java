package ly01;

public class Mower {

	private String name;
	private Cell currentCell;
	private char orientation;
	private Grid grid;

	public Mower(String name, Grid grid, String initalPosition) {
		super();
		this.name = name;
		this.grid = grid;
		this.currentCell = grid.getCell(Character.getNumericValue(Helper.InstructionParser.parse(initalPosition)[0]),
				Character.getNumericValue(Helper.InstructionParser.parse(initalPosition)[1]));
		this.currentCell.setOccupied(true);
		this.orientation = Helper.InstructionParser.parse(initalPosition)[2];
	}

	/**
	 * Process instruction line and move the Mowers
	 * @param command
	 */
	public void move(String command) {
		char[] instructions = Helper.InstructionParser.parse(command);
		for (char c : instructions) {
			switch (c) {
			case Helper.MoveInsctruction.A:
				this.advance();
				break;
			case Helper.MoveInsctruction.D:
				this.orient(Helper.MoveInsctruction.D);
				break;
			case Helper.MoveInsctruction.G:
				this.orient(Helper.MoveInsctruction.G);
				break;
			default:
				System.out.println("\n Unkown instruction: " + c + " ");
				break;
			}
		}
	}

	/**
	 * set the current orientation of the mower based on the instruction
	 * We suppose that D means: In the direction of hands of a watch
	 * 
	 * @param moveInst
	 */
	private void orient(char moveInst) {
		switch (this.orientation) {
		case Helper.Orientation.N:
			if (moveInst == Helper.MoveInsctruction.D)
				this.orientation = Helper.Orientation.E;
			else
				this.orientation = Helper.Orientation.W;
			break;
		case Helper.Orientation.E:
			if (moveInst == Helper.MoveInsctruction.D)
				this.orientation = Helper.Orientation.S;
			else
				this.orientation = Helper.Orientation.N;
			break;
		case Helper.Orientation.S:
			if (moveInst == Helper.MoveInsctruction.D)
				this.orientation = Helper.Orientation.W;
			else
				this.orientation = Helper.Orientation.E;
			break;
		case Helper.Orientation.W:
			if (moveInst == Helper.MoveInsctruction.D)
				this.orientation = Helper.Orientation.N;
			else
				this.orientation = Helper.Orientation.S;
			break;
		default:
			System.out.println("\n Invalid/unknown instruction! ignoring...");
			return;
		}
	}
	
	/**
	 * Advance the mower to it's new position
	 * if the new position is in use or outside the Grid instruction will be ignored
	 * and the mower stay in same position 
	 */
	private void advance() {
		int currentX = this.currentCell.getX();
		int currentY = this.currentCell.getY();
		int nextX = currentX;
		int nextY = currentY;

		switch (this.orientation) {
		case Helper.Orientation.N:
			nextX = currentX;
			nextY = currentY + 1;
			break;
		case Helper.Orientation.E:
			nextX = currentX + 1;
			nextY = currentY;
			break;
		case Helper.Orientation.S:
			nextX = currentX;
			nextY = currentY - 1;
			break;
		case Helper.Orientation.W:
			nextX = currentX - 1;
			nextY = currentY;
			break;
		default:
			System.out.println("\n Invalid orientation! ignoring...");
			return;
		}
		if (this.grid.canMoveToCellAt(nextX, nextY)) {
			this.currentCell.setOccupied(false);
			this.currentCell = this.grid.getCell(nextX, nextY);
			this.currentCell.setOccupied(true);
			return;
		}
		System.out.println("\n Can't move to: x=" + nextX + " y=" + nextY + " \t either the position is outside the grid or currently in use");
	}

	public String getPosition() {
		return this.currentCell.getX() + " " + currentCell.getY() + " " + this.orientation;
	}

}
