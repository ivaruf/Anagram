package no.finn;

import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String one, String two) {
        return true;
    }

    public String sortString(String toBeSorted) {
        char [] sequence = toBeSorted.toCharArray();
        Arrays.sort(sequence);
        return new String(sequence);
    }
}
