package git;

import java.io.IOException;

public class IndexTester {

	public static void main(String[] args) throws IOException {
		Index a = new Index();
		a.start ();
		a.add("Testing/sample.txt");

	}

}
