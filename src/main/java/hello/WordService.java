package hello;

import org.springframework.stereotype.Service;

@Service
public class WordService {

	private static final int NO_OF_CHARS = 256;

	public Pallindrome testPallindromeAndAnagramOfPalindrome(String originalWord) {

		Pallindrome pallindrome = new Pallindrome();
		pallindrome.setWord(originalWord);
		boolean palindrome = true;
		boolean anagramOfPalindrome = true;

		String wordWithClean = originalWord.replaceAll("\\s+", "").toLowerCase();
		int length = wordWithClean.length();
		int forward = 0;
		int backward = length - 1;
		while (backward > forward) {
			char forwardChar = wordWithClean.charAt(forward++);
			char backwardChar = wordWithClean.charAt(backward--);
			if (forwardChar != backwardChar) {
				palindrome = false;
				break;
			}

		}

		if (palindrome) {
			pallindrome.setPalindrome(true);
		}

		// Check anagram 
		int[] count = new int[NO_OF_CHARS];

		for (int i = 0; i < originalWord.length(); i++)
			count[originalWord.charAt(i)]++;

		// Count odd occurring characters 
		int odd = 0;
		for (int i = 0; i < NO_OF_CHARS; i++) {
			if ((count[i] & 1) != 0)
				odd++;

			if (odd > 1) {
				anagramOfPalindrome = false;
				break;
			}
		}

		if (anagramOfPalindrome) {
			pallindrome.setAnagramOfPalindrome(true);
		}

		return pallindrome;
	}

}
