package for_project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Spellchecker {
	
	 private BinarySearchTree<String> dictionary;
	    
	 public Spellchecker() {
		 dictionary = new BinarySearchTree<String>();
	     try {
	    	 Scanner input = new Scanner(new File("wordList.txt"));
	         while (input.hasNextLine()) {
	        	 String word = input.nextLine().trim();
	             dictionary.add(word);
	            }
	         input.close();
	   } catch (FileNotFoundException e) {
		   e.printStackTrace();
	        }
	    }
	
	private String removePunctAndDowncase(String input) {
	    String punctuation = ".,?!-\";:()%$#@";
	    String output = input.replaceAll("[" + punctuation + "]", "");
	    output = output.replaceAll("’", "'");
	    return output.toLowerCase();
	}

	public boolean check(String word) {
		String newWord = removePunctAndDowncase(word);
		if(dictionary.search(newWord) != null) {
			return true;
		}else {
			return false;
		}
	}

}