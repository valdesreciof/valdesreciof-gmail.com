import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DuplicateCounter {
	
	HashMap<String, Integer> wordCounter = new HashMap<>(); 
	
	public void count(String dataFile) {
		File myFile = new File(dataFile);
		try {
			
			Scanner scan = new Scanner(myFile);
			String word;
			scan.useDelimiter("[^A-Za-z]+");	
			while(scan.hasNextLine()){	
				
				word = scan.next().toLowerCase();
				if(!wordCounter.containsKey(word)){
					wordCounter.put(word,1);
				}
				else { 
					int count = wordCounter.get(word).intValue();
					wordCounter.remove(word);
					wordCounter.put(word, count + 1 );
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
            for (String word: wordCounter.keySet()){
                String key = word.toString();
                String value = wordCounter.get(word).toString();  
                System.out.println(key + ": " + value);  
            }		 
    		out.flush();
            out.close(); 
        } 
        catch (Exception e) { 
            System.out.println("Output file not found"); 
        } 
		
	}

}
