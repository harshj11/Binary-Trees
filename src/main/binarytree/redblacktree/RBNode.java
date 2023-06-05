package main.binarytree.redblacktree;

import main.binarytree.Node;

/**
 * @author Harsh Jain
 *
 * @param <T>, representing a node of a type that will be provided at the time node will be created.
 *
 * A class representing the node of a red black tree.
 */
public class RBNode<T> extends Node<T> {
    protected RBNode<T> parent;
    protected Color nodeColor;

    public RBNode(T key) {
        super(key);
        this.nodeColor = Color.RED;
    }

    public Color getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(Color nodeColor) {
        this.nodeColor = nodeColor;
    }

    enum Color { RED, BLACK }

    public RBNode<T> getParent() {
        return parent;
    }

    public void setParent(RBNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBNode{" +
                "key=" + key +
                ", nodeColor=" + nodeColor +
                '}';
    }
}
