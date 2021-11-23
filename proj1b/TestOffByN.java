import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {

    static OffByN offBy5 = new OffByN(5);

    @Test
    public void test1() {
        assertTrue(offBy5.equalChars('a', 'f'));
    }

    @Test
    public void test2() {
        assertTrue(offBy5.equalChars('f', 'a'));
    }

    @Test
    public void test3() {
        assertFalse(offBy5.equalChars('f', 'h'));
    }
}
