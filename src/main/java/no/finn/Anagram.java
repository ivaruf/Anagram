package no.finn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagram {

	public static final String DEFAULT_FILE = "src/main/resources/eventyr.txt";

	private Map<String, List<String>> anagramMap;

	public static void main(String... args) throws Exception {
		String filepath = args.length > 0 ? args[0] : DEFAULT_FILE;
		Anagram anagrams = new Anagram();
		Scanner scanner = anagrams.createScannerFromFilePath(filepath);
		anagrams.populate(anagrams.createWordListFromScanner(scanner));
		anagrams.printAnagrams();
	}

	private void printAnagrams() {
		for (List<String> anagrams : anagramMap.values()) {
			if (anagrams.size() > 1) {
				System.out.println(createCommaSeparated(anagrams) + "\n");
			}
		}
	}

	public String charSorted(String word) {
		char[] sequence = word.toLowerCase().toCharArray();
		Arrays.sort(sequence);
		return new String(sequence);
	}

	public Map<String, List<String>> populate(List<String> dictionary) {
		anagramMap = new HashMap<String, List<String>>();

		for (String word : dictionary) {
			String key = charSorted(word);

			if (anagramMap.containsKey(key)) {
				anagramMap.get(key).add(word);
			} else {
				ArrayList anagrams = new ArrayList();
				anagrams.add(word);
				anagramMap.put(key, anagrams);
			}
		}
		return anagramMap;
	}

	public String createCommaSeparated(List<String> words) {
		String list = words.toString();
		return list.substring(1, list.length() - 1);
	}

	public Scanner createScannerFromFilePath(String filepath) throws FileNotFoundException {
		return new Scanner(new File(filepath));
	}

	public List<String> createWordListFromScanner(Scanner scanner) {
		ArrayList<String> words = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			String word = scanner.nextLine();
			if (word.length() > 0) {
				words.add(word);
			}
		}
		return words;
	}
}
