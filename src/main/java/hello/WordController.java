package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	// TODO Implement the /words/{word} endpoint

	@Autowired
	private WordService wordService;

	@RequestMapping(value = "/words/{word}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pallindrome testPallindromeAndAnagramOfPalindrome(@PathVariable("word") String word) {

		return wordService.testPallindromeAndAnagramOfPalindrome(word);
	}
}
