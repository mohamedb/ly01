package ly01;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MowerInstructionFileTest {

	Grid grid;
	String[] insts = null;

	@Before
	public void initTest() throws Throwable {
		try {
			insts = InstructionFileLoader.toStringArray();
		} catch (IOException e) {
			throw new Exception("File loading/paring error! ");
		}
		this.grid = new Grid(insts[0]);
	}
	
	@Test
	public void requiredTestUsingFile() {
		Mower m1 = new Mower("M1", grid, insts[1]);
	    m1.move(insts[2]);
	    assertEquals("1 3 N", m1.getPosition());
	    
	    Mower m2 = new Mower("M2", grid, insts[3]);
	    m2.move(insts[4]);
	    assertEquals("5 1 E", m2.getPosition());
	}

}
