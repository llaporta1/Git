package git;

public class CommitTester {

	public static void main(String[] args) {
		Commit a  = new Commit (null, "94e66df8cd09d410c62d9e0dc59d3a884e458e05", "cool", "Henry", "9/18/22");
		Commit b  = new Commit (a, "c39cd817c8c954443121382b7f915aab251abc5e", "uncool", "Henry", "9/19/22");
	}

}
