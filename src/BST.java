/**
 * Stub for binary search tree class
 * 
 * @author Yaxuan Zhang
 * @version 2020-10-12
 * @param <T>
 *            the generic type; extends Comparable
 */

public class BST<T extends Comparable<T>> {
    //the root of the BST
    private Node<T> root;
    // a stack that store tree elements in order
    private LStack treeAll;
    /** The size of the BST */
    private int size;

    /**
     * Constructor Instantiates a new Binary Search Tree.
     */
    public BST() {
        root = null;
        size = 0;
    }


    /**
     * insert the value into the BST
     * 
     * @param value
     *            comparable value that need to be inserted
     */
    public void insert(Comparable<T> value) {

        root = inserthelp(root, value);

    }


    /**
     * insert help function of insert
     * 
     * @param rt
     *            current node
     * @param value
     *            value that need to be inserted
     * @return node follow the instruction
     */
    @SuppressWarnings("unchecked")
    private Node<T> inserthelp(Node<T> rt, Comparable<T> value) {
        if (rt == null) {
            this.size++;
            System.out.println("Rectangle accepted:" + value.toString());
            return new Node<T>((T)value);

        }
        if (rt.getValue().compareTo((T)value) >= 0) {
            if (rt.getValue().equals(value)) {
                System.out.println("Rectangle rejected:" + value.toString());
                return rt;
            }
            else {
                rt.setLeft(inserthelp(rt.getLeft(), value));
            }

        }
        else {
            rt.setRight(inserthelp(rt.getRight(), value));
        }
        return rt;
    }


    /**
     * remove function that remove node with the key info
     * 
     * @param value
     *            the value that contain only key info
     * @return removenode the node that is removed
     */
    public Node<T> remove(T value) {
        // first find it the node that is with
        // the same key as the input value
        Node<T> removenode = findhelp(this.root, value);
        if (removenode != null) {
            this.root = removehelp(this.root, value);
            size--;
        }
        return removenode;
    }


    /**
     * remove function that remove with both key and element value info only
     * exact
     * match can be remove
     * 
     * @param value
     *            the value that contain both key and element value
     * @return true
     */
    public boolean removeExact(T value) {
        this.root = removeExacthelp(this.root, value);
        size--;
        return true;
    }


    /**
     * remove help function (remove with key info)
     * 
     * @param rt
     *            current node
     * @param value
     *            value
     * @return node that match the key
     */
    @SuppressWarnings("unchecked")
    private Node<T> removehelp(Node<T> rt, T value) {
        // can not find the corresponding value node
        if (rt == null) {
            return null;
        }

        if (rt.getValue().compareTo(value) > 0) {
            rt.setLeft(removehelp(rt.getLeft(), value));
        }
        else if (rt.getValue().compareTo(value) < 0) {
            rt.setRight(removehelp(rt.getRight(), value));
        }
        else {
            if (rt.getLeft() == null) {
                return rt.getRight();
            }
            else if (rt.getRight() == null) {
                return rt.getLeft();
            }
            else {
                Node<T> temp = getmax(rt.getLeft());
                rt.setValue(temp.getValue());
                rt.setLeft(deletemax(rt.getLeft()));
            }
        }
        return rt;
    }


    /**
     * remove help function (remove with key and element values info)
     * 
     * @param rt
     *            current node
     * @param value
     *            value
     * @return node that match the key
     */
    @SuppressWarnings("unchecked")
    private Node<T> removeExacthelp(Node<T> rt, T value) {
        // can not find the corresponding value node
        if (rt == null) {
            return null;
        }
        if (rt.getValue().compareTo(value) > 0) {
            rt.setLeft(removeExacthelp(rt.getLeft(), value));
        }
        else if (rt.getValue().compareTo(value) < 0) {
            rt.setRight(removeExacthelp(rt.getRight(), value));
        }
        else {
            if (rt.getValue().equals(value)) {
                if (rt.getLeft() == null) {
                    return rt.getRight();
                }
                else if (rt.getRight() == null) {
                    return rt.getLeft();
                }
                else {
                    Node<T> temp = getmax(rt.getLeft());
                    rt.setValue(temp.getValue());
                    rt.setLeft(deletemax(rt.getLeft()));
                }
            }
            else {
                rt.setLeft(removeExacthelp(rt.getLeft(), value));
            }
        }
        return rt;
    }


    /**
     * find help function
     * 
     * @param rt
     *            current node
     * @param value
     *            a variable that the key to find
     * @return rt node that match the key or null
     */
    @SuppressWarnings("unchecked")
    public Node<T> findhelp(Node<T> rt, T value) {
        if (rt == null || rt.getValue().compareTo(value) == 0) {
            return rt;
        }
        if (rt.getValue().compareTo(value) > 0) {
            return findhelp(rt.getLeft(), value);
        }
        return findhelp(rt.getRight(), value);
    }


    /**
     * delete the maximum valued element in a subtree
     * 
     * @param rt
     *            root node of a subtree
     * @return root node of a subtree that its max has been deleted
     */
    @SuppressWarnings("unchecked")
    private Node<T> deletemax(Node<T> rt) {
        if (rt.getRight() == null) {
            return rt.getLeft();
        }
        rt.setRight(deletemax(rt.getRight()));
        return rt;
    }


    /**
     * get the max of a subtree
     * 
     * @param rt
     *            root node of a subtree
     * @return rt node that has the maximum key value of a tree
     */
    @SuppressWarnings("unchecked")
    private Node<T> getmax(Node<T> rt) {
        if (rt.getRight() == null) {
            return rt;
        }

        return getmax(rt.getRight());
    }


    /**
     * dump (print out) the tree information
     */
    public void dump() {
        if (this.size == 0) {
            System.out.println("Node has depth 0, Value (null)");
        }
        else {
            dumphelp(this.root, 0);

        }
        System.out.println("BST size is: " + this.size);

    }


    /**
     * dump help function (in order traverse)
     * 
     * @param rt
     *            root node of the tree/subtree
     * @param depth
     *            current depth of the node
     */
    @SuppressWarnings("unchecked")
    public void dumphelp(Node<T> rt, int depth) {
        if (rt == null) {
            return;
        }
        dumphelp(rt.getLeft(), depth + 1);
        System.out.println("Node has depth " + depth + ", Value " + rt
            .getValue().toString());
        dumphelp(rt.getRight(), depth + 1);

    }


    /**
     * save the tree
     * 
     * @param node
     *            root node of the tree/subtree
     */
    public void savehelp(Node<?> node) {
        if (node == null) {
            return;
        }
        savehelp(node.getLeft());
        this.treeAll.push(node.getValue());
        savehelp(node.getRight());

    }


    /**
     * getter method of the treeAll
     * 
     * @return treeAll a linked stack that contains all value of the tree
     */
    public LStack getTreeAll() {
        return treeAll;
    }


    /**
     * setter method of the treeAll
     * 
     * @param treeAll
     *            the linked stack that contains the tree info
     */
    public void setTreeAll(LStack treeAll) {
        this.treeAll = treeAll;
    }


    /**
     * getter method of root
     * 
     * @return root the root of the tree
     */
    public Node<T> getRoot() {
        return this.root;
    }




}
