/**
 * @author Yaxuan Zhang
 * @version 2020-10-12
 *
 */

public class LStack implements Cloneable {
    //top value on the Stack
    private Link top;
    //size of the Stack
    private int size;

    /**
     * Constructor for the LStack
     * initialize
     * 
     */
    LStack() {
        top = null;
        size = 0;
    }


    /**
     * constructor for LStack
     * initialize
     * 
     * @param size
     *            the size of the stack
     */
    LStack(int size) {
        top = null;
        size = 0;
    }


    /**
     * Reinitialize stack
     */
    public void clear() {
        top = null;
        size = 0;
    }


    /**
     * Put an object on stack
     * 
     * @param it
     *            element to put
     * @return boolean
     *         true
     */
    public boolean push(Object it) {
        top = new Link(it, top);
        size++;
        return true;
    }


    /**
     * Remove object from stack
     * 
     * @return it
     *         remove element
     */
    public Object pop() {
        if (top == null) {
            return null;
        }
        Object it = top.element();
        top = top.next();
        size--;
        return it;
    }


    /**
     * Return the top value
     * 
     * @return top.element()
     *         element on the top
     */
    public Object topValue() {
        if (top == null) {
            return null;
        }
        return top.element();
    }


    /**
     * return the size of the stack
     * 
     * @return size
     *         size
     */
    public int length() {
        return size;
    }


    /**
     * Check if the stack is empty
     * 
     * @return boolean
     *         true if the stack is empty
     *         false if the stack is not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * clone the stack
     * 
     * @return super.clone()
     *         a clone of the stack
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
