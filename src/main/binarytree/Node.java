package main.binarytree;

/**
 * @author Harsh Jain
 *
 * @param <T>, representing a node of a type that will be provided at the time node will be created.
 *
 * A class representing a node with it's left and right subtree.
 */
public class Node<T> {
    protected T key;
    protected Node<T> leftSubTree;
    protected Node<T> rightSubTree;

    public Node(T key) {
        this.key = key;
    }

    public Node(T key, Node<T> leftSubTree, Node<T> rightSubTree) {
        this.key = key;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(Node<T> leftSubTree) {
        this.leftSubTree = leftSubTree;
    }

    public Node<T> getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(Node<T> rightSubTree) {
        this.rightSubTree = rightSubTree;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}
