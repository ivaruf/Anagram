package no.finn;

import java.util.*;

public class Anagram {

    private List<String> dictionary;
    private Map<String,List<String>> anagramMap;

    public boolean isAnagram(String one, String two) {
        return sortString(one).equals(sortString(two));
    }

    public String sortString(String toBeSorted) {
        char [] sequence = toBeSorted.toLowerCase().toCharArray();
        Arrays.sort(sequence);
        return new String(sequence);
    }

    public void setDictionaryAndPopulateAnagramMap(List<String> dictionary) {
        this.dictionary = dictionary;
        anagramMap = new HashMap<String, List<String>>();

        for (String word : dictionary) {
            String key = sortString(word);

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
}
