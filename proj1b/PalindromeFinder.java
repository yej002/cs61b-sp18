import static org.junit.Assert.assertTrue;

/** This class outputs all palindromes in the words file in the current directory. */

public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
//        OffByN offBy4 = new OffByN(4);
//        String word = in.readString();
//        Palindrome palindrome1 = new Palindrome();
//        Deque D4 = palindrome1.wordToDeque(word);
//        assertTrue(offBy4.equalChars(DequeToString(D4.removeFirst()), DequeToString(D4.removeLast()));
//            System.out.println(offBy4.equalChars(word,word));
//        }
//        private String DequeToString(Object d) {
//            String string = "";
//            while (d.size() > 0) {
//                string += d.removeFirst();
//            }
//            return string;
    }
}
