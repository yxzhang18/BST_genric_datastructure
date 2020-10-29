import student.TestCase;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class LStactTest extends TestCase {

    /**
     * test the basic 
     */
    public void testBasic() {
        LStack s = new LStack();
        assertEquals(true, s.push(1));
        assertEquals(true, s.push(2));

        assertEquals(2, s.length());
        assertEquals(2, s.pop());
        assertEquals(1, s.topValue());
        assertEquals(false, s.isEmpty());
        assertEquals(1, s.pop());
        assertEquals(null, s.pop());
        assertEquals(null, s.topValue());
        assertEquals(true, s.isEmpty());
        LStack s1 = new LStack(2);
        assertEquals(true, s1.push(1));
        assertEquals(true, s1.push(2));
        s1.clear();
        assertEquals(0, s.length());
    }

}
