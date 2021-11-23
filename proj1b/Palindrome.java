public class Palindrome {
	public Deque<Character> wordToDeque(String word) {
		Deque<Character> worddeque = new ArrayDeque<>();

		for (int i = 0; i < word.length(); i++) {
			worddeque.addLast(word.charAt(i));
		}

		return worddeque;
	}

	public boolean isPalindrome(String word) {
		Deque<Character> worddeque = wordToDeque(word);

		if (worddeque.size() == 0 || worddeque.size() == 1) {
			return true;
		}
		else if (worddeque.removeFirst() == worddeque.removeLast()) {
			return isPalindrome(DequeToString(worddeque));
		}
		return false;
	}
//helper convert "worddeque" to string
	private String DequeToString(Deque d) {
		String string = "";
		while (d.size() > 0) {
			string += d.removeFirst();
		}
		return string;
	}
}
