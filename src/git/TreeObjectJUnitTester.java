package git;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class TreeObjectJUnitTester {

	@Test
	public void testTreeObject() throws FileNotFoundException {
		ArrayList<String> testList = new ArrayList<String> ();
		testList.add ("some content");
		testList.add ("some more content");
		testList.add ("final contet");
		
		String someContentSHA = "94e66df8cd09d410c62d9e0dc59d3a884e458e05";
		String someMoreContentSHA = "4ca8deacbe9ea18450248727171dae4fd03a1e50";
		String finalContentSHA = "507c87b99ae2f5069f68eaf58757eb514bc156be";
		String allTogetherSHA = "e254308469e4a756c9ff571b9f3750961dca080b";
		
		TreeObject testTree = new TreeObject (testList);
		File textFile = new File ("Testing/objects/" + allTogetherSHA);
		assertTrue ("text file does not have correct name; most likely has incorrect contents, since name of file is result of contents", textFile.exists());
		
		Scanner scanny = new Scanner (textFile);
		StringBuilder buildy = new StringBuilder();
		while (scanny.hasNextLine()) {
			buildy.append(scanny.nextLine());
		}
		String scannyString = scanny.toString();
		assertTrue ("text file did not contain correct info", scannyString.equals("some content : " + someContentSHA + "\nsome more content : " + someMoreContentSHA + "\nfinal content : " + finalContentSHA));
	}

}
