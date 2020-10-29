
/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 */
public class Rectangle implements Comparable<Rectangle> {
    // name of the rectangle
    private String name;
    // x position
    private int x;
    // y position
    private int y;
    // width of the rectangle
    private int width;
    // height of the rectangle
    private int height;

    /**
     * Rectangle constructor for general insertion
     * 
     * @param name
     *            name of the rectangle
     * 
     * @param x
     *            x position
     * 
     * @param y
     *            y position
     * 
     * @param width
     *            width of the rectangle
     * 
     * @param height
     *            height of the rectangle
     */
    public Rectangle(String name, int x, int y, int width, int height) {
        if (!Character.isLetter(name.charAt(0)) || x < 0 || y < 0 || width <= 0
            || height <= 0 || x + width > 1024 || y + height > 1024 || x > 1023
            || y > 1023) {
            System.out.println("Rectangle rejected:" + "(" + name + "," + " "
                + x + "," + " " + y + "," + " " + width + "," + " " + height
                + ")");
        }
        else {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.name = name;
        }

    }


    /**
     * Rectangle constructor build for remove with name <name>
     * 
     * @param name
     *            name of the rectangle
     */
    public Rectangle(String name) {
        this.name = name;
    }


    /**
     * Rectangle constructor build for remove with specific dimensions
     * 
     * @param x
     *            x position
     * 
     * @param y
     *            y position
     * 
     * @param width
     *            width of the rectangle
     * 
     * @param height
     *            height of the rectangle
     */
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    /**
     * getter method
     * 
     * @return x
     *         x position
     */
    public int getX() {
        return x;
    }


    /**
     * getter method
     * 
     * @return y
     *         y position
     */
    public int getY() {
        return y;
    }


    /**
     * getter method
     * 
     * @return width
     *         width of the rectangle
     */
    public int getWidth() {
        return width;
    }


    /**
     * getter method
     * 
     * @return height
     *         height of the rectangle
     */
    public int getHeight() {
        return height;
    }


    /**
     * setter method
     * 
     * @param x
     *            set x position
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * setter method
     * 
     * @param y
     *            set the y position
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * setter method
     * 
     * @param width
     *            set the width
     */
    public void setWidth(int width) {
        this.width = width;
    }


    /**
     * setter method
     * 
     * @param height
     *            set the height
     */
    public void setHeight(int height) {
        this.height = height;
    }


    /**
     * getter method
     * 
     * @return name
     *         name of the rectangle
     */
    public String getName() {
        return name;
    }


    /**
     * setter method
     * 
     * @param name
     *            set the name of rectangle
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * return the compare result
     * 
     * @param anotherRectangle
     *            another rectangle to compare
     * @return 1 if this greater than another rectangle
     *         0 if equal to
     *         -1 if smaller than
     */
    @Override
    public int compareTo(Rectangle anotherRectangle) {
        if (this.name.compareTo(anotherRectangle.name) > 0) {
            return 1;
        }
        else if (this.name.compareTo(anotherRectangle.name) < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }


    /**
     * equals override
     * 
     * @param o
     *            an object to compare
     * @return boolean
     *         true if they are completely equal to each other
     *         false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Rectangle rect = (Rectangle)o;
        return (this.name == rect.name && this.x == rect.x && this.y == rect.y
            && this.width == rect.width && this.height == rect.height);
    }


    /**
     * check two rectangle their dimension equal or not
     * 
     * @param anotherRectangle
     *                          another rectangle
     * @return boolean
     *         true if dimension are equal
     *         false if not
     */
    public boolean dimEqual(Rectangle anotherRectangle) {
        return this.x == anotherRectangle.getX() && this.y == anotherRectangle
            .getY() && this.width == anotherRectangle.getWidth()
            && this.height == anotherRectangle.getHeight();
    }


    /**
     * print the rectangle info
     * 
     * @return string
     *         print info
     */
    @Override
    public String toString() {
        return "(" + this.name + "," + " " + this.x + "," + " " + this.y + ","
            + " " + this.width + "," + " " + this.height + ")";
    }

}
