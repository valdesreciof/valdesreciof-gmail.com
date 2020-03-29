
public class Application {

	public static void main(String[] args) {
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove("Problem1.txt");
		duplicateRemover.write("unique_word.txt");
	}

}
