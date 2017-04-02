package ly01;

public class Helper {
	
  public static class Orientation {
	  public static final char N='N';
	  public static final char W='W';
	  public static final char S='S';
	  public static final char E='E';
  }
  
  public static class MoveInsctruction {
	  public static final char G='G';
	  public static final char D='D';
	  public static final char A='A';
  }
  
  public static class InstructionParser {
	 
	  /**
	   * We suppose instructions string is well formated and contains desired information
	   * for simplicity we ignore edge cases: instructions with unknown chars, non ASCII ....
	   * @param instructions
	   * @return
	   */
	  public static char[] instructions(String instructions) {
		  instructions = instructions.replaceAll("\\s",""); /* Remove space if any */
		  return instructions.toCharArray();
	  }
	  
	  public static String[] initialization(String initStr) {
		  return initStr.split("\\s+"); /* space is the delimiter */
	  }
	   
  }
}
