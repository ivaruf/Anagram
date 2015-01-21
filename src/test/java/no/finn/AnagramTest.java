package no.finn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramTest {

    private Anagram anagram;

    @Before
    public void setUp() {
        anagram = new Anagram();
    }

    @Test
    public void shouldBeAnagram() throws Exception {
        String one = "abcd";
        String two = "bcad";

        assertTrue(anagram.isAnagram(one, two));
    }

    @Test
    public void shouldNotBeAnagram() throws Exception {
        String one = "hei";
        String two = "hopp";

        assertFalse(anagram.isAnagram(one, two));
    }

    @Test
    public void shouldBeAnagramWhenCaseIsNotEqual() throws Exception {
        String one = "Sivle";
        String two = "Elvis";

        assertTrue(anagram.isAnagram(one, two));
    }

    @Test
    public void sortString() throws Exception {
        String toBeSorted = "bfgha";

        assertEquals("abfgh", anagram.sortString(toBeSorted));
    }
}
