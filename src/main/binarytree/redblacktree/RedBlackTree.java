package main.binarytree.redblacktree;

import main.binarytree.BinarySearchTree;

/**
 * @author Harsh Jain
 *
 * A class which helps in creating a red black tree and has methods to perform various operations on a
 * given red black tree.
 *
 * @param <T>, the type of values that will be present in the red black tree.
 */
public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public boolean add(T key) {
        RBNode<T> pointer = (RBNode)root, parent = null;
        int comparisonResult = 0;

        while(pointer != null) {
            parent = pointer;
            comparisonResult = key.compareTo(pointer.getKey());
            if(comparisonResult == 0)
                throw new IllegalArgumentException("Key already present in the tree.");
            else if(comparisonResult < 0)
                pointer = (RBNode)pointer.getLeftSubTree();
            else
                pointer = (RBNode)pointer.getRightSubTree();
        }

        RBNode<T> newNode = new RBNode<>(key);

        // If node to be inserted is the root node.
        if(parent == null) {
            root = newNode;
            return true;
        } else {
            comparisonResult = key.compareTo(parent.getKey());
            if(comparisonResult == -1)
                parent.setLeftSubTree(newNode);
            else
                parent.setRightSubTree(newNode);
            newNode.setParent(parent);
        }

        balanceRedBlackTreeAfterInsert(newNode);

        return true;
    }

    public boolean delete(T key) {
        return false;
    }

    /**
     * Balance the red black tree after inserting a node.
     *
     * @param node after insertion of which tree has to be balanced.
     */
    private void balanceRedBlackTreeAfterInsert(RBNode<T> node) {
        RBNode<T> parent = node.getParent();

        if(parent == null || parent.getNodeColor() == RBNode.Color.BLACK) {
            return;
        }

        RBNode<T> grandParent = parent.getParent();

        if(grandParent == null) {
            parent.setNodeColor(RBNode.Color.BLACK);
            return;
        }

        RBNode<T> parentsSibling = getParentsSibling(node, parent, grandParent);

        if(parentsSibling != null && parentsSibling.getNodeColor() == RBNode.Color.RED) {
            grandParent.setNodeColor(RBNode.Color.RED);
            parent.setNodeColor(RBNode.Color.BLACK);
            parentsSibling.setNodeColor(RBNode.Color.BLACK);

            balanceRedBlackTreeAfterInsert(grandParent);
        } else if(parent == grandParent.getLeftSubTree()) {
            // Left right rotation or right rotation.
            if(node == parent.getRightSubTree()) {
                rotateLeft(parent);
                //parent = node;
            }

            rotateRight(grandParent);
            parent = node;

            // Swapping the colors of grand parent and parent(previously grand child).
            parent.setNodeColor(RBNode.Color.BLACK);
            grandParent.setNodeColor(RBNode.Color.RED);
        } else {
            // Right left rotation or left rotation.
            if (node == parent.getLeftSubTree()) {
                rotateRight(parent);
                //parent = node;
            }

            rotateLeft(grandParent);
            parent = node;

            // Swapping the colors of grand parent and parent(previously grand child).
            parent.setNodeColor(RBNode.Color.BLACK);
            grandParent.setNodeColor(RBNode.Color.RED);
        }
    }

    /**
     * Get sibling of a node's parent.
     *
     * @param node whose parent's sibling is to be found.
     * @param parent whose sibling is to be found.
     * @param grandParent
     * @return
     */
    private RBNode<T> getParentsSibling(RBNode<T> node, RBNode<T> parent, RBNode<T> grandParent) {
        if(grandParent.getLeftSubTree() == parent)
            return (RBNode<T>) grandParent.getRightSubTree();
        return (RBNode<T>) grandParent.getLeftSubTree();
    }

    /**
     * Rotate a node in the left direction.
     *
     * @param node to be rotated.
     */
    private void rotateLeft(RBNode<T> node) {
        RBNode<T> parentNode = node.getParent();
        RBNode<T> rightChildNode = (RBNode<T>) node.getRightSubTree();
        RBNode<T> leftSubTreeOfChildNode = (RBNode<T>) rightChildNode.getLeftSubTree();

        node.setRightSubTree(null);

        if(leftSubTreeOfChildNode != null) {
            node.setRightSubTree(leftSubTreeOfChildNode);
            leftSubTreeOfChildNode.setParent(node);
        }

        node.setParent(rightChildNode);
        rightChildNode.setParent(parentNode);
        rightChildNode.setLeftSubTree(node);

        if(parentNode == null) {
            root = rightChildNode;
            return;
        }

        // Setting parent node's left or right child to new parent, i.e. rightChildNode.
        if(parentNode.getLeftSubTree() == node)
            parentNode.setLeftSubTree(rightChildNode);
        else
            parentNode.setRightSubTree(rightChildNode);
    }

    /**
     * Rotate a node in the right direction.
     *
     * @param node to be rotated.
     */
    private void rotateRight(RBNode<T> node) {
        RBNode<T> parentNode = node.getParent();
        RBNode<T> leftChildNode = (RBNode<T>) node.getLeftSubTree();
        RBNode<T> rightSubTreeOfChildNode = (RBNode<T>) leftChildNode.getRightSubTree();

        node.setLeftSubTree(null);

        if(rightSubTreeOfChildNode != null) {
            node.setLeftSubTree(rightSubTreeOfChildNode);
            rightSubTreeOfChildNode.setParent(node);
        }

        node.setParent(leftChildNode);
        leftChildNode.setParent(parentNode);
        leftChildNode.setRightSubTree(node);

        if(parentNode == null) {
            root = leftChildNode;
            return;
        }

        // Setting parent node's left or right child to new parent, i.e. rightChildNode.
        if(parentNode.getLeftSubTree() == node)
            parentNode.setLeftSubTree(leftChildNode);
        else
            parentNode.setRightSubTree(leftChildNode);
    }
}