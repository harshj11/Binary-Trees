package main.binarytree;

/**
 * @author Harsh Jain
 *
 * A class which helps in creating a binary search tree and has methods to perform various operations on a
 * given binary search tree.
 *
 * @param <T>, the type of values that will be present in the binary search tree.
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(T rootVal) {
        super(rootVal);
    }

    @Override
    public boolean add(T key) {
        if(root == null)
            root = new Node<T>(key);
        else {
            Node<T> ptr = root;
            int comparisonResult = 0;
            while(true) {
                comparisonResult = key.compareTo(ptr.getKey());
                if(comparisonResult == 0) {
                    throw new IllegalArgumentException("Key already present in the tree.");
                } else if(comparisonResult < 0) {
                    Node<T> leftSubTree = ptr.getLeftSubTree();
                    if(leftSubTree == null)
                        break;
                    else
                        ptr = leftSubTree;
                } else {
                    Node<T> rightSubTree  = ptr.getRightSubTree();
                    if(rightSubTree == null)
                        break;
                    else
                        ptr = rightSubTree;
                }
            }

            if(comparisonResult <= 0)
                ptr.setLeftSubTree(new Node<T>(key));
            else
                ptr.setRightSubTree(new Node<T>(key));
        }

        return true;
    }

    @Override
    public boolean delete(T key) {
        if(root == null)
            return false;

        Node<T> pointer = root, parent = null;

        // Finding the node to be deleted.
        while(pointer != null && pointer.getKey() != key) {
            parent = pointer;
            int comparisonResult = key.compareTo(pointer.getKey());
            if(comparisonResult == -1)
                pointer = pointer.getLeftSubTree();
            else if(comparisonResult == 1)
                pointer = pointer.getRightSubTree();
        }

        // If node to be deleted is not present in the tree.
        if(pointer == null)
            return false;

        // If the left or right subtree is not present.
        if(pointer.getLeftSubTree() == null || pointer.getRightSubTree() == null) {

            Node<T> newChild = null;

            if(pointer.getRightSubTree() == null)
                newChild = pointer.getLeftSubTree();
            else
                newChild = pointer.getRightSubTree();

            // If root node has to be deleted.
            if(parent == null) {
                root = newChild;
                return true;
            }

            // Checking whether new subtree will be left or right child of the parent, after deletion of a given node.
            if(parent.getLeftSubTree().getKey() == pointer.getKey())
                parent.setLeftSubTree(newChild);
            else
                parent.setRightSubTree(newChild);
        } else {
            // Finding smallest node in the right subtree of the node to be deleted.
            Node<T> parentOfTheSmallestInRightSubTree = null, smallestInRightSubTree = pointer.getRightSubTree();

            while(smallestInRightSubTree.getLeftSubTree() != null) {
                parentOfTheSmallestInRightSubTree = smallestInRightSubTree;
                smallestInRightSubTree = smallestInRightSubTree.getLeftSubTree();
            }

            // If smallest node in right subtree equals the node to the right of the node to be deleted.
            if(parentOfTheSmallestInRightSubTree == null)
                pointer.setRightSubTree(smallestInRightSubTree.getRightSubTree());
            else
                parentOfTheSmallestInRightSubTree.setLeftSubTree(smallestInRightSubTree.getRightSubTree());

            // Replace the node's value which to be deleted with the smallest in the right subtree.
            pointer.setKey(smallestInRightSubTree.getKey());
        }

        return true;
    }

    @Override
    public Node<T> search(T key) {
        Node<T> pointer = root;
        while(pointer != null) {
            int comparisonResult = key.compareTo(pointer.getKey());
            if(comparisonResult == 0)
                return pointer;
            if(comparisonResult == -1)
                pointer = pointer.getLeftSubTree();
            else
                pointer = pointer.getRightSubTree();
        }

        return pointer;
    }
}
