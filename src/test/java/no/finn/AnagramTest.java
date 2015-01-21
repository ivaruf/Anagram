package no.finn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnagramTest {

    @Test
    public void shouldBeAnagram() throws Exception {
        String one = "abcd";
        String two = "bcad";

        Anagram anagram = new Anagram();

        assertTrue(anagram.isAnagram(one, two));
    }

    @Test
    public void sortString() throws Exception {
        String toBeSorted = "bfgha";
        Anagram anagram = new Anagram();

        assertEquals("abfgh", anagram.sortString(toBeSorted));
    }
}
