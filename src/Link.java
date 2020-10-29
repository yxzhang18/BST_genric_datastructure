
/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */
public class Link {
    // saved object
    private Object e;
    // next link
    private Link n;

    /**
     * constructor of the class
     * 
     * @param it
     *            element that save to this link
     * @param inn
     *            next link
     */
    Link(Object it, Link inn) {
        e = it;
        n = inn;
    }


    /**
     * constructor of the class
     * 
     * @param inn
     *            next link
     */
    Link(Link inn) {
        e = null;
        n = inn;
    }


    /**
     * getter method of the element
     * 
     * @return e
     *         element/value
     */
    Object element() {
        return e;
    }


    /**
     * setter method of the element
     * 
     * @param it
     *            value
     * @return e
     *         element value
     */
    Object setElement(Object it) {
        this.e = it;
        return e;
    }


    /**
     * @return
     *         next link
     */
    Link next() {
        return n;
    }


    /**
     * setter method of the pointer
     * 
     * @param inn
     *            next link
     * @return
     *         next link
     */
    Link setNext(Link inn) {
        this.n = inn;
        return n;
    }

    /**
     * Extensions to support freelists
     * 
     */
    // Freelist for the class
    private static Link freelist = null;

    /**
     * Return a new link, from freelist if possible
     * 
     * @param it
     *            the element value
     * @param inn
     *            next link
     * @return Link
     *         setted up link
     */
    static Link get(Object it, Link inn) {
        if (freelist == null) {
            // Get from "new"
            return new Link(it, inn);
        }

        // Get from freelist
        Link temp = freelist;
        freelist = freelist.next();
        temp.setElement(it);
        temp.setNext(inn);
        return temp;
    }


    /**
     * Return a link node to the freelist
     */
    void release() {
        e = null; // Drop reference to the element
        n = freelist;
        freelist = this;
    }
}
