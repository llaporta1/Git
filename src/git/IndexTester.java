package git;

import java.io.IOException;

public class IndexTester {

	public static void main(String[] args) throws IOException {
		Index a = new Index();
		a.start ();
		a.add("Testing/sample.txt");
		a.add("Testing/epic.txt");
		a.add("Testing/epic2.txt");
//		a.remove("Testing/objects/94e66df8cd09d410c62d9e0dc59d3a884e458e05.txt");

	}

}
