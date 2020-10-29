import student.TestCase;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class NodeTest extends TestCase {

    
    /**
     * test the isLeaf function
     */
    public void testIsLeaf() {
        Rectangle rect = new Rectangle("Charlie", 1, 2, 3, 4);
        Node<Rectangle> t = new Node<Rectangle>(rect);
        assertEquals(true, t.isLeaf());
        Rectangle rect1 = new Rectangle("Charlie", 1, 3, 3, 4);
        Node<Rectangle> t2 = new Node<Rectangle>(rect1);

        Rectangle rect2 = new Rectangle("Charlie", 1, 8, 3, 4);
        Node<Rectangle> t3 = new Node<Rectangle>(rect2);
        t3.setLeft(t2);
        t3.setRight(t);
        assertEquals(t2, t3.getLeft());
        assertEquals(t, t3.getRight());
        t3.setValue(rect);
        assertEquals(rect, t3.getValue());

        t.setLeft(t2);
        assertEquals(false, t.isLeaf());
        t.setRight(t3);
        assertEquals(false, t.isLeaf());
    }

}
