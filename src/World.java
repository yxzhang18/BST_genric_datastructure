
/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class World {

    private BST<Rectangle> bst;

    /**
     * constructor for World
     * initialize
     */
    public World() {
        this.bst = new BST<Rectangle>();
    }


    /**
     * insert the rectangle information into the tree
     * 
     * @param rectInfo
     *            rectangle information
     */
    public void insert(String rectInfo) {
        String[] rectInfoL = rectInfo.split("\\s");
        String name = rectInfoL[0];
        int x = Integer.parseInt(rectInfoL[1]);
        int y = Integer.parseInt(rectInfoL[2]);
        int width = Integer.parseInt(rectInfoL[3]);
        int height = Integer.parseInt(rectInfoL[4]);

        Rectangle rect = new Rectangle(name, x, y, width, height);
        if (rect.getName() != null) {
            bst.insert(rect);
        }

    }


    /**
     * search all the rectangle in certain region
     * 
     * @param regInfo
     *            region infomation
     */
    public void regSearch(String regInfo) {
        String[] regInfoL = regInfo.split("\\s+");
        int x = Integer.parseInt(regInfoL[0]);
        int y = Integer.parseInt(regInfoL[1]);
        int width = Integer.parseInt(regInfoL[2]);
        int height = Integer.parseInt(regInfoL[3]);

        if (width <= 0 || height <= 0) {
            return;
        }

        int ymax = y + height;
        int xmax = x + width;

        LStack treeAll = new LStack();
        bst.setTreeAll(treeAll);
        bst.savehelp(bst.getRoot());
        int flag = 0;
        while (!treeAll.isEmpty()) {
            Rectangle temp = (Rectangle)treeAll.pop();
            if (pointCheck(temp, x, xmax, y, ymax)) {
                flag++;
                if (flag == 1) {
                    System.out.println("Rectangles intersecting region (" + x
                        + ", " + y + ", " + width + ", " + height + "):");
                    System.out.println(temp.toString());
                }
                else {
                    System.out.println(temp.toString());
                }
            }
        }

    }


    /**
     * check whether rectangle fall in certain region
     * 
     * @param temp
     *            the rectangle being check
     * @param xmin
     *            region: minimum x value
     * @param xmax
     *            region: maximum x value
     * @param ymin
     *            region: minimum y value
     * @param ymax
     *            region: maximum y value
     * @return
     */
    private boolean pointCheck(
        Rectangle temp,
        int xmin,
        int xmax,
        int ymin,
        int ymax) {
        int xGmin = Math.max(temp.getX(), xmin);
        int xGmax = Math.min(temp.getX() + temp.getWidth(), xmax);
        int yGmin = Math.max(temp.getY(), ymin);
        int yGmax = Math.min(temp.getY() + temp.getHeight(), ymax);
        
        return xGmax > xGmin && yGmax > yGmin;
    }


    /**
     * print out all the intersected rectangles in the tree
     * 
     */
    public void interSearch() {
        System.out.println("Intersection pairs:");

        LStack outer = new LStack();
        bst.setTreeAll(outer);
        bst.savehelp(bst.getRoot());

        while (!outer.isEmpty()) {
            Rectangle temp = (Rectangle)outer.pop();
            LStack inner = new LStack();
            try {
                inner = (LStack)outer.clone();
            }
            catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            while (!inner.isEmpty()) {
                Rectangle innerTemp = (Rectangle)inner.pop();
                boolean check = pointCheck(innerTemp, temp.getX(), temp.getX()
                    + temp.getWidth(), temp.getY(), temp.getY() + temp
                        .getHeight());
                if (check) {
                    System.out.println(temp.toString() + " : " + innerTemp
                        .toString());
                }
            }

        }

    }


    /**
     * dump the tree info
     * 
     * @return boolean
     *         always true if used
     */
    public boolean dump() {
        System.out.println("BST dump:");
        bst.dump();
        return true;
    }


    /**
     * remove rectangle by given info it could be remove by name or remove by
     * dimensions
     * 
     * @param info
     *            input info from the commend
     * @return boolean
     *         true if the node is removed
     *         false if not
     */
    public boolean remove(String info) {
        String[] infoA = info.split("\\s");
        if (infoA.length == 1) {
            return removebyName(infoA[0]);
        }
        else {
            int x = Integer.parseInt(infoA[0]);
            int y = Integer.parseInt(infoA[1]);
            int width = Integer.parseInt(infoA[2]);
            int height = Integer.parseInt(infoA[3]);
            return removebyDimension(x, y, width, height);
        }
    }


    /**
     * remove rectangle by name
     * 
     * @param name
     *            rectangle name
     * @return boolean
     *         true if the rectangle can be removed by name
     *         flase if not
     */
    public boolean removebyName(String name) {
        Rectangle temp = new Rectangle(name);
        Node<Rectangle> removeCheck = bst.remove(temp);
        if (removeCheck == null) {
            System.out.println("Rectangle rejected " + name);
            return false;
        }
        return true;
    }


    /**
     * remove rectangle by dimension
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param width
     *            width of Rectangle
     * @param height
     *            height of Rectangle
     * @return boolean 
     *                  true if there is rectangle removed 
     *                  false if not
     */
    public boolean removebyDimension(int x, int y, int width, int height) {
        Rectangle temp = new Rectangle(x, y, width, height);

        LStack treeAll = new LStack();
        bst.setTreeAll(treeAll);
        bst.savehelp(bst.getRoot());

        while (!treeAll.isEmpty()) {
            Rectangle rect = (Rectangle)treeAll.pop();
            if (rect.dimEqual(temp)) {
                bst.removeExact(rect);
                return true;
            }
        }
        System.out.println("Rectangle rejected " + "(" + x + "," + " " + y + ","
            + " " + width + "," + " " + height + ")");
        return false;
    }


    /**
     * print out all the rectangle that has the same name 
     * @param name
     *              name to be search 
     */
    public void search(String name) {
        Rectangle sRec = new Rectangle(name);
        LStack treeAll = new LStack();
        bst.setTreeAll(treeAll);
        bst.savehelp(bst.getRoot());
        int flag = 0;
        while (!treeAll.isEmpty()) {
            Rectangle temp = (Rectangle)treeAll.pop();
            if (temp.compareTo(sRec) == 0) {
                System.out.println("Rectangle found: " + temp.toString());
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("Rectangle not found: " + name);
        }

    }

}
