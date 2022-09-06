package git;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Index {
	FileWriter iWriter;
	public Index () {	
	}
	
	public void start () throws IOException {
		File index = new File ("Testing/index.txt");
		iWriter =  new FileWriter (index);
		File objectsFolder = new File("Testing/objects");
		objectsFolder.mkdir();
	}
	
	public void add (String fileName) throws IOException {
		StringBuilder newString = new StringBuilder ();
		newString.append(fileName + " : ");
		Blob newBlob = new Blob (fileName);
		newString.append("" + newBlob.getSHAString() + "\n");
		iWriter.write(newString.toString());
	}
	
	public void remove (String fileName) throws IOException {
		int numOfCharsInFileName = fileName.length();
		File f = new File (fileName);
		f.delete();
		Scanner fileScanner = new Scanner ("Testing/index.txt");
		StringBuilder newString = new StringBuilder ();
		while (fileScanner.hasNext()) {
			String newLine = fileScanner.next();
			if (!(newLine.substring(0, numOfCharsInFileName).equals(fileName))) {
				newString.append(newLine);
			}
		}
		iWriter.write(newString.toString());
	}
}
