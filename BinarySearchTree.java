package assignment9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


/**
 * A generic binary search tree implementation.
 *
 * @param <T> the type of elements maintained by this tree
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>{

    /**
     * Constructs an empty binary search tree.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Getter to the number of elements in the tree.
     * @return the number of elements in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Getter to the root node of the tree.
     * @return the root node of the tree
     */
    public Node<T> getRoot() {
        return this.root;
    }

    /**
     * Checks if the tree contains a specific value.
     * @param value the value to check for
     * @return true if the value in the tree, false otherwise
     */
    public boolean contains(T value) {
        return get(value) != null;
    }

    /**
     * Retrieves a value from the tree
     * @param value the value to retrieve
     * @return the value if it's in the tree, null otherwise
     */
    public T get(T value) {
        if (value == null) {
            return null;
        }
        return recursiveGet(root, value);
    }

    /**
     * Helper method to recursively get a value from the tree.
     * @param node  the node to start the search from
     * @param value the value to search for
     * @return the value if found, null otherwise
     */
    private T recursiveGet(Node<T> node, T value) {
        if (node == null) { // stop condition
            return null;
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) { // go left
            return recursiveGet(node.left, value);
        } else if (cmp > 0) { // go right
            return recursiveGet(node.right, value);
        } else {
            return node.value;
        }
    }

    /**
     * Returns an iterator over the elements in the tree in-order sequence.
     * @return an iterator over the elements in this tree
     */
    public Iterator<T> iterator() {
        return new InOrderIterator<>(root);
    }

    /**
     * Adds a value to the tree.
     * @param value the value to add
     * @return true if the value was added, false if it already in it
     */
    public boolean add(T value) {
        // check for unNull value
        if (value == null) {
            return false;
        }
        // check if the value already exist
        if (contains(value)) {
            return false;
        }
        root = recursiveAdd(root, value);
        size++;
        return true;
    }

    /**
     * Helper method to recursively add a value to the tree.
     * @param node  the node to start the addition from
     * @param value the value to add
     * @return the new node with the value added
     */
    private Node<T> recursiveAdd(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = recursiveAdd(node.left, value);
        } else if (cmp > 0) {
            node.right = recursiveAdd(node.right, value);
        }
        return node;
    }


    // private variables of the Binary Search Tree
    private Node<T> root;
    private int size;


    /**
     * Class of a node in the binary search tree.
     * @param <T> the type of value held by this node
     */
    public static class Node<T> {

        /**
         * Constructs a new node with the specified value.
         * @param value the value of the new node
         */
        Node(T value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }

        /**
         * Getter to the right child of this node.
         * @return the right child of this node
         */
        public Node<T> getRight() {
            return right;
        }

        /**
         * Getter to the left child of this node.
         * @return the left child of this node
         */
        public Node<T> getLeft() {
            return left;
        }

        /**
         * Getter to value of this node.
         * @return the value of this node
         */
        public T getValue() {
            return value;
        }

        // private variables of the Node
        private Node<T> right;
        private Node<T> left;
        private T value;
    }

    /**
     * Iterator over the elements in a binary search tree in-order sequence.
     * @param <T> the type of elements returned by this iterator
     */
    public static class InOrderIterator<T> implements Iterator<T> {
        private Stack<Node<T>> stack = new Stack<>();

        /**
         * Constructs an in-order iterator starting from the specified root node.
         * @param root the root node to start the iteration from
         */
        InOrderIterator(Node<T> root) {
            pushLeft(root);
        }

        /**
         * Pushes all the left children of the specified node onto the stack.
         * @param node the node to start pushing from
         */
        private void pushLeft(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * Checks if there are more elements to iterate over.
         * @return true if there are more elements, false otherwise
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the iterator");
            }
            Node<T> node = stack.pop();
            T result = node.getValue();
            if (node.right != null) {
                pushLeft(node.right);
            }
            return result;
        }

    }
}
