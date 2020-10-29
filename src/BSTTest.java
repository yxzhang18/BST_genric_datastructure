import java.io.IOException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the BST function (you should throw this away for your project)
 *
 * @author Yaxuan Zhang
 * @version 2020-10-12
 */
public class BSTTest extends TestCase {

    /**
     * setUp the condition.
     */
    public void setUp() {
        // Nothing to setup here. May not be true for your tests
    }


    /**
     * Test basic.
     */
    public void testBasic() throws IOException {

        BST<Rectangle> theTree1 = new BST<Rectangle>();
        assertNotNull(theTree1);
        theTree1.dump();
        theTree1.getRoot();

        Rectangle t5 = new Rectangle("a", 1, 0, 2, 4);
        Rectangle t6 = new Rectangle("c", 4, 3, 6, 1);
        Rectangle t7 = new Rectangle("b", 2, 5, 123, 6);
        Rectangle t8 = new Rectangle("d", 3, 5, 123, 6);
        Rectangle t10 = new Rectangle("a", 1, 0, 2, 4);
        theTree1.insert(t5);
        theTree1.insert(t6);
        theTree1.insert(t7);
        theTree1.insert(t8);
        theTree1.insert(t10);

        theTree1.dump();

        assertFuzzyEquals("Node has depth 0, Value (null)\n"
            + "BST size is: 0\n" + "Rectangle accepted:(a, 1, 0, 2, 4)\n"
            + "Rectangle accepted:(c, 4, 3, 6, 1)\n"
            + "Rectangle accepted:(b, 2, 5, 123, 6)\n"
            + "Rectangle accepted:(d, 3, 5, 123, 6)\n"
            + "Rectangle rejected:(a, 1, 0, 2, 4)\n"
            + "Node has depth 0, Value (a, 1, 0, 2, 4)\n"
            + "Node has depth 2, Value (b, 2, 5, 123, 6)\n"
            + "Node has depth 1, Value (c, 4, 3, 6, 1)\n"
            + "Node has depth 2, Value (d, 3, 5, 123, 6)\n" + "BST size is: 4",
            systemOut().getHistory());

    }


    /**
     * test the find help function in BST
     */
    public void testfindhelp() {
        BST<Rectangle> theTree1 = new BST<Rectangle>();
        Rectangle t5 = new Rectangle("a", 1, 0, 2, 4);
        Rectangle t6 = new Rectangle("c", 4, 3, 6, 1);
        Rectangle t7 = new Rectangle("b", 2, 5, 123, 6);
        Rectangle t8 = new Rectangle("d", 3, 5, 123, 6);
        Rectangle t10 = new Rectangle("a", 1, 0, 2, 4);
        theTree1.insert(t5);
        theTree1.insert(t6);
        theTree1.insert(t7);
        theTree1.insert(t8);
        theTree1.insert(t10);

        Rectangle t = new Rectangle("a");
        assertEquals(true, theTree1.findhelp(theTree1.getRoot(), t) != null);
    }


    /**
     * test the save help function in BST
     */
    public void testsavehelp() {

        BST<Rectangle> theTree1 = new BST<Rectangle>();
        theTree1.setTreeAll(new LStack());
        theTree1.savehelp(theTree1.getRoot());
        Rectangle t5 = new Rectangle("a", 1, 0, 2, 4);
        Rectangle t6 = new Rectangle("c", 4, 3, 6, 1);
        Rectangle t7 = new Rectangle("b", 2, 5, 123, 6);
        Rectangle t8 = new Rectangle("d", 3, 5, 123, 6);
        Rectangle t10 = new Rectangle("a", 1, 0, 2, 4);
        theTree1.insert(t5);
        theTree1.insert(t6);
        theTree1.insert(t7);
        theTree1.insert(t8);
        theTree1.insert(t10);
        theTree1.savehelp(theTree1.getRoot());
        theTree1.dump();
        assertEquals(t8, theTree1.getTreeAll().topValue());

    }


    /**
     * test the remove function in BST
     */
    public void testremove() {
        BST<Rectangle> theTree1 = new BST<Rectangle>();
        theTree1.savehelp(theTree1.getRoot());
        Rectangle t5 = new Rectangle("a", 1, 0, 2, 4);
        Rectangle t6 = new Rectangle("c", 4, 3, 6, 1);
        Rectangle t7 = new Rectangle("b", 2, 5, 123, 6);
        Rectangle t8 = new Rectangle("d", 3, 5, 123, 6);
        Rectangle t10 = new Rectangle("a", 1, 0, 2, 4);
        Rectangle t9 = new Rectangle("h", 1, 2, 3, 4);
        theTree1.insert(t5);
        theTree1.insert(t6);
        theTree1.insert(t7);
        theTree1.insert(t8);
        theTree1.insert(t10);
        assertEquals(t8, theTree1.remove(t8).getValue());
        Rectangle test = new Rectangle("d", 3, 5, 123, 6);
        assertEquals(true, theTree1.removeExact(test));
        assertEquals(null, theTree1.remove(t9));

    }

}
