package git;

import java.io.IOException;

public class CommitTester {

	public static void main(String[] args) throws IOException {
		Commit a  = new Commit (null, "a", "cool", "Henry", "9/18/22");
		Commit b = new Commit (a.getNode(), "b", "cooler", "Henry", "9/19/22");
		Commit c  = new Commit (b.getNode(), "c", "very cool", "Henry", "9/18/22");
		b.writeFile();
	}

}
