import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 */
public class RectangleDBTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     * 
     * @throws IOException
     */
    public void testRInit() throws IOException {
        RectangleDB manager = new RectangleDB();
        assertNotNull(manager);
        String[] args = { "SimpleInsertionTest.txt" };
        RectangleDB.main(args);
        assertFuzzyEquals("BST dump:\n" + "Node has depth 0, Value (null)\n"
            + "BST size is: 0\n" + "Rectangle accepted:(a, 1, 0, 2, 4)\n"
            + "Rectangle accepted:(b, 4, 3, 6, 1)\n"
            + "Rectangle accepted:(c, 2, 5, 123, 6)\n" + "BST dump:\n"
            + "Node has depth 0, Value (a, 1, 0, 2, 4)\n"
            + "Node has depth 1, Value (b, 4, 3, 6, 1)\n"
            + "Node has depth 2, Value (c, 2, 5, 123, 6)\n" + "BST size is: 3",
            systemOut().getHistory());

        systemOut().clearHistory();
        String[] args1 = { "complexcase.txt" };
        RectangleDB.main(args1);
        byte[] testByte = Files.readAllBytes(Paths.get("complexOutput.txt"));
        String test = new String(testByte);
        assertFuzzyEquals(test, systemOut().getHistory());

    }
}
