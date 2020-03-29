
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DuplicateRemover {	
	
	ArrayList<String> uniqueWords = new ArrayList<>();
	
	public void remove(String dataFile) {		
		File myFile = new File(dataFile);
		try {
			
			Scanner scan = new Scanner(myFile);
			String word;
			scan.useDelimiter("[^A-Za-z]+");	
			while(scan.hasNextLine()){	
				
				word = scan.next().toLowerCase();
				if(!uniqueWords.contains(word)){
					uniqueWords.add(word);
				}
			}
			
			scan.close();
			
		} catch (FileNotFoundException e) {		 	
			System.out.println("Input file not found");			
		} catch(NoSuchElementException e) {}
	}
	
	public void write(String outputFile) {
		File myFile = new File(outputFile);
		try { 
            BufferedWriter out = new BufferedWriter(new FileWriter(myFile, true)); 
    		for(String word: uniqueWords) {
    			out.write(word); 
    			out.newLine(); 
    		}
            out.close(); 
        } 
        catch (Exception e) { 
            System.out.println("Output file not found"); 
        } 

	}

}
