package ly01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InstructionFileLoader {
	
	public static final String FILE_PATH = "prog.txt";

	public static String[] toStringArray() throws IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(FILE_PATH));
		String[] instructions = new String[5];
		String line = null;
		int lineCounter = 0;
		while ((line = bufferReader.readLine()) != null) {
			if (lineCounter == 5) { /* we are only interested in the 5 first lines */
				System.out.println(" File: "+ FILE_PATH + " contains +5 lines, ignoring ...");
				bufferReader.close();
				break;
			}
			instructions[lineCounter] = line;
			lineCounter++;
		}
		bufferReader.close();
		return instructions;
	}
}
