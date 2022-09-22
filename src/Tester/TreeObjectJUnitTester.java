package Tester;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import git.TreeObject;

public class TreeObjectJUnitTester {

	@Test
	public void testTreeObject() throws FileNotFoundException {
		ArrayList<String> testList = new ArrayList<String> ();
		testList.add("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f testfile1.txt");
		testList.add("blob : 01d82591292494afd1602d175e165f94992f6f5f testfile2.txt");
		testList.add("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83 testfile3.txt");
		testList.add("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b testfile4.txt");
		testList.add("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976 testfile5.txt");
//		testList.add ("some content");
//		testList.add ("some more content");
//		testList.add ("final content");
		
		String sha1String = "2bcd8661bf13275afdd0aa44a86b95397b2651fe";
//		String someContentSHA = "94e66df8cd09d410c62d9e0dc59d3a884e458e05";
//		String someMoreContentSHA = "4ca8deacbe9ea18450248727171dae4fd03a1e50";
//		String finalContentSHA = "507c87b99ae2f5069f68eaf58757eb514bc156be";
//		String allTogetherSHA = "e254308469e4a756c9ff571b9f3750961dca080b";
		
		TreeObject testTree = new TreeObject (testList);
		File textFile = new File ("objects/" + sha1String);
		assertTrue ("text file does not have correct name; most likely has incorrect contents, since name of file is result of contents", textFile.exists());
		
		Scanner scanny = new Scanner (textFile);
		StringBuilder buildy = new StringBuilder();
		while (scanny.hasNextLine()) {
			buildy.append(scanny.nextLine());
		}
		String scannyString = scanny.toString();
		assertTrue ("text file did not contain correct info", scannyString.equals("testfile1.txt testfile2.txt testfile3.txt testfile4.txt testfile5.txt"));

}
}
