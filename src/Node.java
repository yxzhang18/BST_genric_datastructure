/**
 * Stub for Node class
 * 
 * @author Yaxuan Zhang
 * @version 2020-10-12
 * @param <T>
 *            the generic type; extends Comparable
 */

public class Node<T extends Comparable<T>> {

    //element value 
    private Comparable<T> value;
    //left childnode 
    private Node<T> left;
    //right childnode
    private Node<T> right;

    /**
     * Instantiates a new node.
     *
     * @param value2
     *            the value
     */
    public Node(T value2) {
        this.value = value2;
        this.left = null;
        this.right = null;
    }


    
    /**
     * getter method for element value
     * @return value
     */
    public Comparable<T> getValue() {
        return value;
    }


    /**
     * setter method for the element value
     * @param comparable
     *                      comparable variable 
     */                 
    public void setValue(Comparable<T> comparable) {
        this.value = comparable;
    }


    
    /**
     * getter method for the left child node 
     * @return left
     *              left child node
     */
    public Node<T> getLeft() {
        return left;
    }


    
    /**
     * setter method for the left child node
     * @param left
     *              a node 
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * getter method for the right child node 
     * @return right
     *              right child node
     */
    @SuppressWarnings("rawtypes")
    public Node getRight() {
        return right;
    }

    /**
     * setter method for the right child node
     * @param right
     *              a node 
     */
    @SuppressWarnings("unchecked")
    public void setRight(Node<?> right) {
        this.right = (Node<T>)right;
    }


    
    /**
     * check node is the leaf or not 
     * @return boolean 
     *                  true if it is leaf
     *                  false if it is not leaf
     */
    public boolean isLeaf() {

        return (left == null && right == null);
    }
}
