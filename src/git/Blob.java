package git;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Blob {
	private String SHAString;
	public Blob (String fileName) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader (fileName));
		StringBuilder temp = new StringBuilder();
		while (br.ready()) {
			char c = (char) br.read();
			temp.append(c);
		}
		String fileString = new String (temp.toString());
		String SHAString = new String (SHA1.encryptThisString(fileString));
		this.SHAString = SHAString;
		
		File newBlob = new File ("Testing/objects/"+ SHAString + ".txt");
		FileWriter myWriter = new FileWriter (newBlob);
		myWriter.write(fileString);
		myWriter.close();;
		
	}
	
	public String getSHAString () {
		return SHAString;
	}
}
