package no.finn;

import java.util.*;

public class Anagram {

    private List<String> dictionary;
    private Map<String,List<String>> anagramMap;

    public boolean isAnagram(String one, String two) {
        return charSorted(one).equals(charSorted(two));
    }

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

    public List<String> getDictionary() {
        return dictionary;
    }

    public Map<String,List<String>> getAnagramMap() {
        return anagramMap;
    }

	public List<String> getAnagramsFor(String word) {
		String key = charSorted(word);
		List<String> anagramList = anagramMap.get(key);
		List<String> copy = new ArrayList(anagramList);
		copy.remove(key);
		return copy;
	}
}
