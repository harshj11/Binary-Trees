package main.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Harsh Jain
 *
 * An abstract class which has all the basic methods related to binary tree data structure. An implementing class
 * would define the logic as per the tree's type.
 *
 * @param <T>, the type of values that will be present in the binary tree.
 */
public abstract class BinaryTree<T> {

    protected Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T rootVal) {
        this.root = new Node<>(rootVal);
    }

    /**
     * Get the root node in a given binary tree.
     *
     * @return root node.
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Add a node in the tree.
     * @return true, if node was successfully added into the tree, otherwise false.
     */
    public abstract boolean add(T key);

    /**
     * Delete a node with given key from the tree.
     *
     * @param key
     * @return true, if the node was deleted successfully, otherwise false.
     */
    public abstract boolean delete(T key);

    /**
     * Search for a node with given key in the tree.
     *
     * @param key
     * @return node with the given key if found, otherwise null.
     */
    public abstract Node<T> search(T key);

    /**
     * Perform level order traversal on a tree.
     *
     * @return a list of nodes containing level order traversal of a tree.
     */
    public List<Node<T>> getLevelOrderTraversal() {
        Deque<Node<T>> queue = new ArrayDeque<>();
        queue.offerLast(root);

        List<Node<T>> nodes = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node<T> curr = queue.poll();
            nodes.add(curr);
            if(curr.getLeftSubTree() != null) {
                queue.offerLast(curr.getLeftSubTree());
            }
            if(curr.getRightSubTree() != null) {
                queue.offerLast(curr.getRightSubTree());
            }
        }

        return nodes;
    }
}
