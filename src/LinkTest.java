import student.TestCase;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class LinkTest extends TestCase {
    /**
     * test the basic
     */
    @SuppressWarnings("static-access")
    public void testBasic() {
        Link l = new Link(null);
        Link l1 = new Link(1, null);
        l.setElement(2);
        l.setNext(l1);
        assertEquals(2, l.element());
        assertEquals(l1, l.next());
        l.release();
        l.get(3, l1);
        assertEquals(3, l.element());

    }
}
