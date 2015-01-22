package no.finn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagram {

    private List<String> dictionary;
    private Map<String,List<String>> anagramMap;

    public String charSorted(String word) {
        char [] sequence = word.toLowerCase().toCharArray();
        Arrays.sort(sequence);
        return new String(sequence);
    }

    public void populate(List<String> dictionary) {
        this.dictionary = dictionary;
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
    }

	public List<String> getAnagramsFor(String word) {
		String key = charSorted(word);
		List<String> anagramList = anagramMap.get(key);
		List<String> copy = new ArrayList(anagramList);
		copy.remove(key);
		return copy;
	}

	public String createCommaSeparated(List<String> words) {
		if (words == null || words.isEmpty()) {
			return "";
		}
		String list = words.toString();
		return list.substring(1, list.length() -1);
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
