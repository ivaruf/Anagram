package no.finn;

import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String one, String two) {
        return sortString(one).equals(sortString(two));
    }

    public String sortString(String toBeSorted) {
        char [] sequence = toBeSorted.toLowerCase().toCharArray();
        Arrays.sort(sequence);
        return new String(sequence);
    }
}
