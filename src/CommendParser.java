import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class CommendParser {

    private World myWorld;

    /**
     * the constructor for the parser
     * 
     * @param world
     *            the world database
     */
    public CommendParser(World world) {
        this.myWorld = world;
    }


    /**
     * read function of the parser
     * 
     * @param theFile
     *            file need to be parser
     * @return boolean
     *         return true if the file is read
     *         false if not
     * @throws IOException
     */
    public boolean readCmdFile(File theFile) throws IOException {
        Scanner myReader = new Scanner(theFile);
        while (myReader.hasNext()) {
            String cmd = myReader.next();
            if (cmd.equals("insert")) {
                String rectInfo = myReader.nextLine().trim();
                rectInfo = rectInfo.replaceAll("\\s+", " ");
                myWorld.insert(rectInfo);

            }
            else if (cmd.equals("regionsearch")) {
                String regionInfo = myReader.nextLine().trim();
                regionInfo = regionInfo.replaceAll("\\s+", " ");
                myWorld.regSearch(regionInfo);

            }
            else if (cmd.equals("intersections")) {
                myWorld.interSearch();
            }
            else if (cmd.equals("dump")) {
                myWorld.dump();
            }
            else if (cmd.equals("search")) {
                String searchInfo = myReader.nextLine().trim();
                searchInfo = searchInfo.replaceAll("\\s+", " ");
                myWorld.search(searchInfo);
            }
            else if (cmd.equals("remove")) {
                String removeInfo = myReader.nextLine().trim();
                removeInfo = removeInfo.replaceAll("\\s+", " ");
                myWorld.remove(removeInfo);
            }
            else {
                System.out.println(cmd + " is not supported by the parser...");
                System.out.println("Please check with your input...");
                myReader.hasNextLine();
            }

        }
        myReader.close();
        return true;
    }
}
