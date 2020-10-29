import student.TestCase;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class RectangleTest extends TestCase {

    /**
     * test for rectangle
     */
    public void testRectangle() {
        Rectangle t = new Rectangle("Charlie", -1, 1, 3, 4);
        Rectangle t1 = new Rectangle("Charlie", 1, 1, 1, 0);
        Rectangle t2 = new Rectangle("Charlie", 1, 1, 1, 1);

        assertEquals(null, t.getName());
        assertEquals(null, t1.getName());
        assertEquals("Charlie", t2.getName());
        assertEquals(null, t1.getName());

        assertFuzzyEquals("Rectangle rejected:(Charlie, -1, 1, 3, 4)\n" + 
            "Rectangle rejected:(Charlie, 1, 1, 1, 0)", systemOut()
                .getHistory());
        systemOut().clearHistory();
        System.out.println(t2.getHeight());
        System.out.println(t2.getWidth());
        System.out.println(t2.getName());
        System.out.println(t2.getX());
        System.out.println(t2.getY());
        assertFuzzyEquals("1\n" + "1\n" + "Charlie\n" + "1\n" + "1", systemOut()
            .getHistory());

        t2.setHeight(1);
        t2.setName("test");
        t2.setWidth(2);
        t2.setX(1);
        t2.setY(3);

    }


    /**
     * test for compareTo
     */
    public void testCompareTo() {
        Rectangle t = new Rectangle("Charlie", 1, 2, 3, 4);
        Rectangle t1 = new Rectangle("Charlie", 2, 3, 7, 1);
        assertEquals(0, t.compareTo(t1));

        Rectangle t2 = new Rectangle("charlie", 1, 2, 3, 4);
        assertEquals(-1, t.compareTo(t2));
        assertEquals(1, t2.compareTo(t));
    }


    /**
     * test for equals
     */
    public void testEquals() {
        Rectangle t = new Rectangle("Charlie", 1, 2, 3, 4);
        Rectangle t1 = new Rectangle("Charlie", 1, 2, 3, 4);
        Rectangle t2 = new Rectangle("charlie", 1, 2, 3, 4);
        Rectangle t3 = new Rectangle("charlie", 1, 3, 3, 4);

        int a = 0;
        assertEquals(true, t.equals(t1));
        assertEquals(false, t2.equals(t1));
        assertEquals(false, t2.equals(t3));
        assertEquals(false, t3.equals(a));

    }


    /**
     * test the toString function
     */
    public void testToString() {
        Rectangle t = new Rectangle("Charlie", 1, 2, 3, 4);
        assertEquals("(Charlie, 1, 2, 3, 4)", t.toString());
    }


    /**
     * test the dimEqual function
     */
    public void testdimEqual() {
        Rectangle t = new Rectangle("Charlie", 1, 2, 3, 4);
        Rectangle t1 = new Rectangle("Yaxuan", 1, 2, 3, 4);
        assertEquals(true, t.dimEqual(t1));
    }

}
