
public class Application {

	public static void main(String[] args) {
		DuplicateCounter duplicateRemover = new DuplicateCounter();
		duplicateRemover.count("Problem2.txt");
		duplicateRemover.write("unique_word.txt");

	}

}
