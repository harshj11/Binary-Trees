package main.binarytree;

import main.binarytree.redblacktree.RBNode;
import main.binarytree.redblacktree.RedBlackTree;

import java.util.*;

public class Application {
    public static void main(String[] args) {
//        Node<Integer> node = new Node<>(1);
//        Node<String> node1 = new Node<>("Hello");
//        Node<Float> node2 = new Node<>(20.32f);
//
//        //node.setLeftSubtree(node1);
//        //node.setRightSubtree(node2);
//
//        Node<Integer> test = node.getLeftSubtree();
//        System.out.println(test);
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>(4);
//        bst.add(2);
//        bst.add(1);
//        bst.add(3);
//        bst.add(8);
//        bst.add(7);
//        bst.add(9);
//
//        bst.delete(8);
//        BinarySearchTree<String> bst = new BinarySearchTree<>("GT");
//        bst.add("RCB");
//        bst.add("SRH");
//        bst.add("CSK");
//        bst.add("LSG");
//        bst.add("MI");
//        bst.add("RR");
//
//        System.out.println(bst.search("GT").getKey());

        RedBlackTree<Integer> bst = new RedBlackTree<>();

        bst.add(4);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(8);
        bst.add(10);
        bst.add(11);
        bst.add(1);
        bst.add(2);

        List<Node<Integer>> nodes = bst.getLevelOrderTraversal();

//        RBNode<Integer> root = (RBNode<Integer>) bst.getRoot();
//        Deque<RBNode<Integer>> queue = new ArrayDeque<>();
//        queue.offerLast(root);
//        List<RBNode<Integer>> nodes = new ArrayList<>();
//        while(!queue.isEmpty()) {
//            RBNode<Integer> curr = queue.poll();
//            nodes.add(curr);
//            if(curr.getLeftSubTree() != null) {
//                queue.offerLast((RBNode<Integer>) curr.getLeftSubTree());
//            }
//            if(curr.getRightSubTree() != null) {
//                queue.offerLast((RBNode<Integer>) curr.getRightSubTree());
//            }
//        }

        System.out.println(nodes);

//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//
//        System.out.print("Time required for inserting thousand nodes into bst.");
//        long startBst = System.nanoTime();
//        for(int i = 1; i <= 30000; i++) {
//            bst.add(i);
//        }
//        long endBst = System.nanoTime();
//
//        System.out.println((endBst - startBst));
//
//        RedBlackTree<Integer> rbt = new RedBlackTree<>();
//
//        System.out.print("Time required for inserting thousand nodes into rbt.");
//        long startRbt = System.nanoTime();
//        for(int i = 1; i <= 30000; i++) {
//            //System.out.println("Inserted " + i + " in rb tree");
//            rbt.add(i);
//        }
//        long endRbt = System.nanoTime();
//
//        System.out.println((endRbt - startRbt));
//
//
//        long t1 = System.nanoTime();
//        Node<Integer> searchedNode1 = bst.search(150);
//        long t2 = System.nanoTime();
//        Node<Integer> searchedNode2 = rbt.search(150);
//        long t4 = System.nanoTime();
//
//        System.out.println(t2 - t1);
//        System.out.println(t4 - t2);
    }
}
