package git;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class Commit {
	private CommitNode node;
	
	public Commit (CommitNode parent, String pTree, String summary, String author, String date) {
		CommitNode newNode = new CommitNode (pTree, summary, author, date);
		parent.setChild(newNode);
		newNode.setParent(parent);
		node = newNode;
		
		String sha = Commit.encryptThisString("" + summary + "" + date + "" + author + "" + parent);
		
	}
	
	public String getDate () {
		return Commit.encryptThisString(node.getDate());
	}
	
	public CommitNode getNode () {
		return node;
	}
	
	public void writeFile () throws IOException {
		StringBuilder fileString = new StringBuilder();
		fileString.append ("objects/" + node.getPTree() + "\n");
		if (node.getParent().getPTree() != null ) {
			fileString.append("objects/" + node.getParent().getPTree() + "\n");
		}
		if (node.getChild().getPTree() != null ) {
			fileString.append("objects/" + node.getChild().getPTree() + "\n");
		}
		fileString.append ("" + node.getAuthor() + "\n");
		fileString.append("" + node.getDate () + "\n");
		fileString.append("" + node.getSummary());
		File newFile = new File ("Testing/objects/" + getDate());
		FileWriter fileWritey =new FileWriter (newFile);
		fileWritey.write(fileString.toString());
		fileWritey.close();
	}
	
	 public static String encryptThisString(String input)
	    {
	        try {
	            // getInstance() method is called with algorithm SHA-1
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	 
	            // digest() method is called
	            // to calculate message digest of the input string
	            // returned as array of byte
	            byte[] messageDigest = md.digest(input.getBytes());
	 
	            // Convert byte array into signum representation
	            BigInteger no = new BigInteger(1, messageDigest);
	 
	            // Convert message digest into hex value
	            String hashtext = no.toString(16);
	 
	            // Add preceding 0s to make it 32 bit
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	 
	            // return the HashText
	            return hashtext;
	        }
	 
	        // For specifying wrong message digest algorithms
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
	
	
}
