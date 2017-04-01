package ly01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MowerAppTest {
	
	Grid grid;
	
	@Before
	public void initTest() {
		this.grid = new Grid("5 5");
	}

	@Test
	public void requiredTest() {
		Mower m1 = new Mower("M1", grid, "1 2 N");
	    m1.move("GAGAGAGAA");
	    assertEquals("1 3 N", m1.getPosition());
	    
	    Mower m2 = new Mower("M2", grid, "3 3 E");
	    m2.move("AADAADADDA");
	    assertEquals("5 1 E", m2.getPosition());
	}
	
	@Test
	public void moveFromX0Y0ToX1Y1Test(){
		Mower m = new Mower("M3", grid, "0 0 N");
		m.move("ADA");
		assertEquals("1 1 E", m.getPosition());
	}
	
	@Test
	public void shouldNotTwoMowersOccupiedSamePosition() {
		Mower m1 = new Mower("M2", grid, "1 1 E");
		Mower m = new Mower("M3", grid, "0 0 N");
		m.move("ADA");
	    assertNotEquals(m1.getPosition(), m.getPosition());
	}
	
	@Test
	public void shouldNotMoveOutsideOfTheGrid(){
		Mower m = new Mower("M3", grid, "0 0 N");
		m.move("AGAAAAJ");
		assertEquals("0 1 W", m.getPosition());
	}

}
