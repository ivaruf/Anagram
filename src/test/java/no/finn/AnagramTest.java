package no.finn;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.*;

public class AnagramTest {

	private Anagram anagrams;

	@Before
	public void setUp() {
		anagrams = new Anagram();
	}

	@Test
	public void shouldNotBeAnagram() {
		String one = "hei";
		String two = "hopp";

		assertNotEquals(anagrams.charSorted(one), anagrams.charSorted(two));
	}

	@Test
	public void shouldBeAnagramWhenCaseIsNotEqual() {
		String one = "Sivle";
		String two = "Elvis";

		assertEquals(anagrams.charSorted(one), anagrams.charSorted(two));
	}

	@Test
	public void sortString() {
		String toBeSorted = "bfgha";

		assertEquals("abfgh", anagrams.charSorted(toBeSorted));
	}

	@Test
	public void testPopulate() {
		Map<String, List<String>> result = anagrams.populate(Arrays.asList("elv", "hum", "lev", "vel"));

		assertEquals(2, result.size());
		assertEquals(3, result.get("elv").size());
		assertEquals(1, result.get("hmu").size());
	}

	@Test
	public void formatedStringShouldNotHaveCommaAfterLastWord() {
		String expected = "lev, vel";
		String result = anagrams.createCommaSeparated(Arrays.asList("lev", "vel"));

		assertEquals(expected, result);
	}

	@Test
	public void formatedStringShouldHaveNoCommasIfOnlyOneWord() {
		String expected = "lev";
		String result = anagrams.createCommaSeparated(Arrays.asList("lev"));

		assertEquals(expected, result);
	}

	@Test
	public void scannerFromDefaultFileShouldHave_1140_Words() throws FileNotFoundException {
		Scanner scanner = anagrams.createScannerFromFilePath(Anagram.DEFAULT_FILE);
		List<String> result = new ArrayList<String>();

		while (scanner.hasNextLine()) {
			String word = scanner.nextLine();
			result.add(word);
		}

		assertEquals(1140, result.size());
	}

	@Test
	public void dictionaryCreatedFromScannerShouldNotContainEmptyStrings() throws FileNotFoundException {
		Scanner scanner = anagrams.createScannerFromFilePath(Anagram.DEFAULT_FILE);
		List result = anagrams.createWordListFromScanner(scanner);
		assertEquals(1139, result.size());
		assertFalse(result.contains(""));
	}
}
