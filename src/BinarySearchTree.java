/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, Mohammad Kashif, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: mnk665
 *  email address: mohammadnkashif@utexas.edu
 *  TA name: Pranav Chandupatla
 *  Number of slip days I am using: 2
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Shell for a binary search tree class.
 * @author scottm
 * @param <E> The data type of the elements of this BinarySearchTree.
 * Must implement Comparable or inherit from a class that implements
 * Comparable.
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    // Instance Variables
    private BSTNode<E> root;
    private int size;

    /**
     *  Default constructor for Binary Search Tree. Initializes size to 0.
     */
    public BinarySearchTree() {
        size = 0;
    }

    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    public boolean add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
        int startSize = size;
        root = addHelp(root, value);
        return startSize != size;
    }

    /**
     *  Recursive helper method for add.
     *  pre: none
     *  post: Recursively loops through binary search tree until correct position for the node
     *  being added is found, then the node is inserted and size incremented.
     */
    private BSTNode<E> addHelp (BSTNode<E> n, E val) {
        if (n == null) {
            size++;
            return new BSTNode<>(val);
        }
        else {
            // dir helps decide whether to move to right or left node by
            // comparing current node to node being inserted.
            int dir = val.compareTo(n.data);
            if (dir < 0) {
                n.left = addHelp(n.left, val);
            }
            else if (dir > 0)  {
                n.right = addHelp(n.right, val);
            }
            return n;
        }
    }

    /**
     *  Remove a specified item from this Binary Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    public boolean remove(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
        int startSize = size;
        root = removeHelper(root, value);
        return startSize != size;
    }

    /**
     *  Recursive helper method for remove.
     *  pre: none
     *  post: Recursively loops through Binary Search Tree until correct element needing to be
     *  removed is found, then handles removal and size decrement through base case.
     */
    private BSTNode<E> removeHelper(BSTNode<E> curr, E val) {
        if (curr == null) {
            return null;
        }
        int diff = val.compareTo(curr.data);
        if (diff < 0) {
            curr.left = removeHelper(curr.left, val);
        }
        else if (diff > 0){
            curr.right = removeHelper(curr.right, val);
        }
        else {
            if (curr.left == null && curr.right == null) {
                curr = null;
                size--;
            }
            else if (curr.left == null) {
                curr = curr.right;
                size--;
            }
            else if (curr.right == null) {
                curr = curr.left;
                size--;
            }
            else {
                curr.data = max(curr.left);
                curr.left = removeHelper(curr.left, curr.data);
            }
        }
        return curr;
    }

    /**
     *  Helper method for remove method.
     *  pre: none
     *  post: Returns largest element in Binary Search tree starting from the given node position.
     */
    private E max(BSTNode<E> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @return true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
        return presenceHelper(root, value);
    }

    /**
     *  Recursively check to see if the specified element is in this Binary Search Tree.
     *  pre: none
     *  post: return true if value is present in tree, false otherwise
     */
    private boolean presenceHelper(BSTNode<E> curr, E value) {
        if (curr == null) {
            return false;
        }
        // diff helps decide which direction to continue search in based on
        // comparison of curr node data and needed data.
        int diff = curr.data.compareTo(value);
        if (diff == 0) {
            return true;
        }
        if (diff > 0) {
            return presenceHelper(curr.left, value);
        }
        return presenceHelper(curr.right, value);
    }

    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @return the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @return the height of this tree or -1 if the tree is empty
     */
    public int height() {
        if (size == 0) {
            return -1;
        }
        return heightHelper(root);
    }

    /**
     *  Recursive helper method for height.
     *  pre: none<br>
     *  post: return the height of this tree.
     *  Returns the max of the height found from searching downwards
     *  in the directions of both the right and left nodes.
     */
    private int heightHelper (BSTNode<E> curr) {
        if (curr == null) {
            return -1;
        }
        return 1 + Math.max(heightHelper(curr.left), heightHelper(curr.right));
    }

    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order.
     *  If the tree is empty return an empty List
     *  @return a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
        ArrayList<E> results = new ArrayList<>();
        getFromPos(root, results);
        return results;
    }

    /**
     *  Recursive helper method for getAll.
     *  pre: none<br>
     *  post: Add all elements of the Binary Search Tree starting from current node to
     *  the results ArrayList in sorted order.
     *  if the tree is empty the list stays empty.
     */
    private void getFromPos(BSTNode<E> current, ArrayList<E> results) {
        if (current == null) {
            return;
        }
        getFromPos(current.left, results);
        results.add(current.data);
        getFromPos(current.right, results);
    }

    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
        if (size < 0) {
            throw new IllegalArgumentException("Size of tree can't be less than zero.");
        }
        if (root == null) {
            return null;
        }
        BSTNode<E> temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.data;
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
        if (size < 0) {
            throw new IllegalArgumentException("Size of tree can't be less than zero.");
        }
        if (root == null) {
            return null;
        }
        BSTNode<E> temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    /**
     * An add method that implements the add algorithm iteratively
     * instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree,
     * otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add,
     * false otherwise.
     */
    public boolean iterativeAdd(E data) {
        if (data == null) {
            throw new IllegalArgumentException("Data can't be null.");
        }
        BSTNode<E> newNode = new BSTNode<>(data);
        if (root == null) {
            root = newNode;
            size++;
            return true;
        }
        BSTNode<E> curr = root;
        return performAdd(data, newNode, curr);
    }

    /**
     * Helper method for iterativeAdd.
     * <br>pre: none
     * <br>post: Iteratively loops through binary search tree to
     * find correct insertion point, insert data, and then increment size accordingly.
     */
    private boolean performAdd(E data, BSTNode<E> newNode, BSTNode<E> curr) {
        while (curr != null) {
            int diff = data.compareTo(curr.data);
            if (diff == 0) {
                return false;
            }
            else if (diff < 0) {
                if (curr.left == null) {
                    curr.left = newNode;
                    size++;
                    return true;
                }
                else {
                    curr = curr.left;
                }
            }
            else {
                if (curr.right == null) {
                    curr.right = newNode;
                    size++;
                    return true;
                }
                else {
                    curr = curr.right;
                }
            }
        }
        return false;
    }


    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the
     * smallest value (minimum) is returned.
     * If kth = 1 the second smallest value is returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Binary Search Tree
     */
    public E get(int kth) {
        if (kth < 0 || kth > size) {
            throw new IllegalArgumentException("kth must be in range if Binary Tree.");
        }
        int[] index = {0};
        return getHelp(index, kth, root);
    }

    /**
     * Recursive helper method for get method.
     * <br>pre: none
     * Performs an in order traversal while incrementing index in an external index array
     * until desired index is reached.
     */
    private E getHelp(int[] currentIndex, int kth, BSTNode<E> curr) {
        if (curr == null) {
            return null;
        }
        E leftRet = getHelp(currentIndex, kth, curr.left);
        if (leftRet != null) {
            return leftRet;
        }
        if (currentIndex[0] == kth) {
            return curr.data;
        }
        currentIndex[0]++;
        return getHelp(currentIndex, kth, curr.right);
    }


    /**
     * Return a List with all values in this Binary Search Tree
     * that are less than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than
     * the parameter value. If there are no values in this tree less
     * than value return an empty list. The elements of the list are
     * in ascending order.
     */
    public List<E> getAllLessThan(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
        ArrayList<E> results = new ArrayList<>();
        getLessThan(root, results, value);
        return results;
    }

    /**
     * Recursive helper method for getAllLessThan.
     * pre: none
     * Uses comparison to E data to decide which direction to recursively loop and return
     * all elements found less than given data.
     */
    private void getLessThan(BSTNode<E> current, ArrayList<E> results, E data) {
        if (current == null) {
            return;
        }
        getLessThan(current.left, results, data);
        if (current.data.compareTo(data) < 0) {
            results.add(current.data);
            getLessThan(current.right, results, data);
        }
    }

    /**
     * Return a List with all values in this Binary Search Tree
     * that are greater than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater
     *  than the parameter value. If there are no values in this tree
     * greater than value return an empty list.
     * The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can't be null.");
        }
        ArrayList<E> results = new ArrayList<>();
        getGreaterThan(root, results, value);
        return results;
    }

    /**
     * Recursive helper method for getAllGreaterThan.
     * pre: none
     * Uses comparison to E data to decide which direction to recursively loop and return
     * all elements found greater than given data.
     */
    private void getGreaterThan(BSTNode<E> current, ArrayList<E> results, E data) {
        if (current == null) {
            return;
        }
        if (current.data.compareTo(data) > 0) {
            getGreaterThan(current.left, results, data);
            results.add(current.data);
        }
        getGreaterThan(current.right, results, data);
    }

    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
        return nodesAtDepthHelper(root, 0, d);
    }

    /**
     * Recursive helper method for numNodesAtDepth.
     * <br>pre: none
     * Recursively searches for number of nodes at a given depth in both left and right
     * node direction, then returns sum of all nodes found.
     */
    private int nodesAtDepthHelper(BSTNode<E> current, int depth, int required) {
        if (current == null) {
            return 0;
        }
        if (depth == required) {
            return 1;
        }
        int leftCount = nodesAtDepthHelper(current.left, depth + 1, required);
        int rightCount = nodesAtDepthHelper(current.right, depth + 1, required);
        return leftCount + rightCount;
    }

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children will not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * <br>pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null);
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,
                BSTNode<E> initRight) {
            data = initValue;
            left = initLeft;
            right = initRight;
        }

        public E getData() {
            return data;
        }

        public BSTNode<E> getLeft() {
            return left;
        }

        public BSTNode<E> getRight() {
            return right;
        }

        public void setData(E theNewValue) {
            data = theNewValue;
        }

        public void setLeft(BSTNode<E> theNewLeft) {
            left = theNewLeft;
        }

        public void setRight(BSTNode<E> theNewRight) {
            right = theNewRight;
        }
    }
}
