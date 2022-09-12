package git;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Index {
	FileWriter iWriter;
	private HashMap<String, String> blobStorage = new HashMap<String, String>();
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
		Scanner fileCopier = new Scanner (new File ("Testing/index.txt"));
		while (fileCopier.hasNextLine()) {
			String newLine = fileCopier.nextLine();
			newString.append(newLine);
			System.out.println (newLine);
			newString.append("\n");
		}
		fileCopier.close();
		newString.append(fileName + " : ");
		Blob newBlob = new Blob (fileName);
		blobStorage.putIfAbsent(fileName, newBlob.getSHAString());
		System.out.println (blobStorage.get(fileName));
		newString.append("" + blobStorage.get(fileName) + "\n");
		FileWriter indexWriter = new FileWriter ("Testing/index.txt");
		indexWriter.write(newString.toString());
		indexWriter.close();
	}
	
	public void remove (String fileName) throws IOException {
		int numOfCharsInFileName = fileName.length();
		File toDelete = new File ("Testing/objects/" + blobStorage.get("Testing/" + fileName) + ".txt");
		toDelete.delete();
		Scanner fileScanner = new Scanner (new File ("Testing/index.txt"));
		StringBuilder newString = new StringBuilder ();
		while (fileScanner.hasNextLine()) {
			String newLine = fileScanner.nextLine();
			if (!(newLine.substring(8, 8 + numOfCharsInFileName).equals(fileName))) {
				newString.append(newLine);
				newString.append("\n");
			}
		}
		FileWriter indexWriter = new FileWriter ("Testing/index.txt");
		indexWriter.write(newString.toString());
		indexWriter.close();
	}
}
