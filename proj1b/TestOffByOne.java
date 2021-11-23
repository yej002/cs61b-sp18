import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    static OffByOne off = new OffByOne();

    @Test
    public void test1() {
        assertTrue(off.equalChars('a', 'b'));
    }
    @Test
    public void test2() {
        assertFalse(off.equalChars('a', 'c'));
    }
    @Test
    public void test3() {
        assertTrue(off.equalChars('1', '2'));
    }
    @Test
    public void test4() {
        assertFalse(off.equalChars('a', 'B'));
    }
    @Test
    public void test5(){
        assertTrue(off.equalChars('%', '&'));
    }
}
