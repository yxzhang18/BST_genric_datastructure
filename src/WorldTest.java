import java.io.IOException;
import student.TestCase;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 */
public class WorldTest extends TestCase {

    
    /**
     * test basic
     * @throws IOException
     */
    public void testBasic() throws IOException {

        World world1 = new World();
        world1.insert("a 1 2 3 4");

        assertFuzzyEquals("Rectangle accepted:(a, 1, 2, 3, 4)", systemOut()
            .getHistory());
        systemOut().clearHistory();
        world1.dump();
        assertFuzzyEquals("BST dump:\n"
            + "Node has depth 0, Value (a, 1, 2, 3, 4)\n" + "BST size is: 1",
            systemOut().getHistory());
        assertEquals(true, world1.dump());
    }


    /**
     * test remove function
     */
    public void testremove() {
        World world1 = new World();
        world1.insert("a 1 2 3 4");
        world1.insert("b 1 2 3 4");
        systemOut().clearHistory();
        world1.dump();
        assertEquals(true, world1.removebyName("b"));
        world1.insert("b 1 2 3 4");
        systemOut().clearHistory();
        assertEquals(false, world1.removebyName("c"));
        assertFuzzyEquals("Rectangle rejected c", systemOut().getHistory());
        systemOut().clearHistory();
        world1.insert("g 1 2 3 4");
        world1.insert("d 1 2 3 4");
        world1.insert("e 1 2 3 4");
        world1.insert("h 1 2 3 4");
        world1.insert("z 1 2 3 4");
        world1.insert("c 1 2 3 4");
        world1.dump();
        assertEquals(true, world1.removebyName("c"));
        assertEquals(true, world1.removebyName("g"));
        assertEquals(true, world1.removebyName("h"));

    }


    /**
     * test remove by dimension function
     */
    public void testremovebyDimension() {
        World world1 = new World();
        world1.insert("a 1 2 3 4");
        world1.insert("g 2 4 127 6");
        world1.insert("d 2 4 124 6");
        world1.insert("a 1 0 2 4");
        world1.insert("e 2 4 125 6");
        world1.insert("e 1 4 125 6");
        world1.dump();
        assertEquals(true, world1.remove("1 4 125 6"));
        assertEquals(false, world1.remove("1 1 1 1"));

    }


    /**
     * test search function
     */
    public void testsearch() {
        World world1 = new World();
        world1.insert("a 1 2 3 4");
        world1.insert("g 2 4 127 6");
        world1.insert("d 2 4 124 6");
        world1.insert("a 1 0 2 4");
        world1.insert("e 2 4 125 6");
        world1.insert("e 1 4 125 6");
        world1.dump();
        systemOut().clearHistory();
        world1.search("e");
        assertEquals("Rectangle found: (e, 2, 4, 125, 6)\n"
            + "Rectangle found: (e, 1, 4, 125, 6)\n", systemOut().getHistory());
        systemOut().clearHistory();
        world1.search("Yaxuan");
        assertEquals("Rectangle not found: Yaxuan\n", systemOut().getHistory());
    }


    /**
     * test region search function
     */
    public void testregSearch() {
        World world1 = new World();
        world1.insert("a 1 2 3 4");
        world1.insert("g 2 4 127 6");
        world1.insert("d 2 4 124 6");
        world1.insert("a 1 0 2 4");
        world1.insert("e 2 4 125 6");
        world1.insert("e 1 4 125 6");
        world1.dump();
        systemOut().clearHistory();
        world1.regSearch("3 5 20000 20000");
        assertEquals("Rectangles intersecting region (3, 5, 20000, 20000):\n"
            + "(g, 2, 4, 127, 6)\n" + "(e, 2, 4, 125, 6)\n"
            + "(e, 1, 4, 125, 6)\n" + "(d, 2, 4, 124, 6)\n"
            + "(a, 1, 2, 3, 4)\n", systemOut().getHistory());
    }


    /**
     * test intersection search function
     */
    public void testinterSearch() {
        World world1 = new World();
        world1.insert("a 1 2 3 4");
        world1.insert("g 2 4 127 6");
        world1.insert("d 2 4 124 6");
        world1.insert("a 1 0 2 4");
        world1.insert("e 2 4 125 6");
        world1.insert("e 1 4 125 6");
        systemOut().clearHistory();
        world1.interSearch();
        assertEquals("Intersection pairs:\n"
            + "(g, 2, 4, 127, 6) : (e, 2, 4, 125, 6)\n"
            + "(g, 2, 4, 127, 6) : (e, 1, 4, 125, 6)\n"
            + "(g, 2, 4, 127, 6) : (d, 2, 4, 124, 6)\n"
            + "(g, 2, 4, 127, 6) : (a, 1, 2, 3, 4)\n"
            + "(e, 2, 4, 125, 6) : (e, 1, 4, 125, 6)\n"
            + "(e, 2, 4, 125, 6) : (d, 2, 4, 124, 6)\n"
            + "(e, 2, 4, 125, 6) : (a, 1, 2, 3, 4)\n"
            + "(e, 1, 4, 125, 6) : (d, 2, 4, 124, 6)\n"
            + "(e, 1, 4, 125, 6) : (a, 1, 2, 3, 4)\n"
            + "(d, 2, 4, 124, 6) : (a, 1, 2, 3, 4)\n"
            + "(a, 1, 2, 3, 4) : (a, 1, 0, 2, 4)\n", systemOut().getHistory());

    }

}
