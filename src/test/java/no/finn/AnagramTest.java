package no.finn;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramTest {

    private Anagram anagrams;

    @Before
    public void setUp() {
        anagrams = new Anagram();
    }

    @Test
    public void shouldBeAnagram() throws Exception {
        String one = "abcd";
        String two = "bcad";

        assertTrue(anagrams.isAnagram(one, two));
    }

    @Test
    public void shouldNotBeAnagram() throws Exception {
        String one = "hei";
        String two = "hopp";

        assertFalse(anagrams.isAnagram(one, two));
    }

    @Test
    public void shouldBeAnagramWhenCaseIsNotEqual() throws Exception {
        String one = "Sivle";
        String two = "Elvis";

        assertTrue(anagrams.isAnagram(one, two));
    }

    @Test
    public void sortString() throws Exception {
        String toBeSorted = "bfgha";

        assertEquals("abfgh", anagrams.charSorted(toBeSorted));
    }

    @Test
    public void inputListPopulatesDictionaryAndAnagramMap() throws Exception {
        String [] input = {"Hei", "Hopp", "ieh", "notanagram", "ppoh"};
        anagrams.populate(Arrays.asList(input));

        assertEquals(5, anagrams.getDictionary().size());
        assertEquals(3, anagrams.getAnagramMap().size());
    }
}
