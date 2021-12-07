package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(2.11);
        arb.enqueue(4.11);
        arb.enqueue(6.11);
        arb.enqueue(8.11);
        arb.dequeue();
        assertEquals(10,arb.capacity());
        assertEquals(3,arb.fillCount());
        System.out.println(arb.peek());
        arb.dequeue();
        assertEquals(10,arb.capacity());
        assertEquals(2,arb.fillCount());
        System.out.println(arb.peek());
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);

    }
} 
