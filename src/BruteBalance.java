import jsjf.*;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * ...
 *
 * @author Mohammad Chaudhry
 * Student Number: T00554758
 * References:
 * https://stackoverflow.com/questions/36097236/java-balance-a-binary-tree-with-brute-force
 */
public class BruteBalance {


  private LinkedBinaryTree<Integer> tree;

  /**
   * Builds the binary tree based on the contents of the given file
   *
   * @param filename the name of the input file
   * @throws FileNotFoundException if the input file is not found
   */
  public BruteBalance(String filename) throws FileNotFoundException {
    File inputFile = new File(filename);
    Scanner scan = new Scanner(inputFile);
    int numberNodes = scan.nextInt();
    scan.nextLine();
    int root = 0, left, right;

    List<LinkedBinaryTree<Integer>> nodes = new java.util.ArrayList<LinkedBinaryTree<Integer>>();

    for (int i = 0; i < numberNodes; i++) {
      nodes.add(i, new LinkedBinaryTree<Integer>(scan.nextInt()));
      scan.nextLine();
    }


    while (scan.hasNext()) {
      root = scan.nextInt();
      left = scan.nextInt();
      right = scan.nextInt();
      scan.nextLine();

      nodes.set(root, new LinkedBinaryTree<Integer>((nodes.get(root)).getRootElement(),
              nodes.get(left), nodes.get(right)));
    }
    tree = nodes.get(root);
  }

  /**
   * Follows the decision tree based on user responses.
   */
  public void evaluate() {
    LinkedBinaryTree<Integer> current = tree;
    Scanner scan = new Scanner(System.in);

    while (current.size() > 1) {
      System.out.println(current.getRootElement());
      if (scan.nextLine().equalsIgnoreCase("N"))
        current = current.getLeft();
      else
        current = current.getRight();
    }
    System.out.println(current.getRootElement());
  }

  /**
   * Copies the tree into a list and calls a private function to balance the tree
   */
  public void balance() {

    //copy tree to list
    Iterator iter = tree.iteratorInOrder();
    List<Integer> myList = new ArrayList<>(tree.size());
    while (iter.hasNext()) {
      myList.add((Integer) iter.next());
    }

    //balance the tree
    tree.setRoot(balanceTree(myList));
  }

  /**
   * This method balances a tree by taking the middle element of the list and setting it as a the root.
   * Then recursively building a balanced left and right subtree
   *
   * @param list the copy of the tree (in list form) to be balanced.
   */
  private BinaryTreeNode balanceTree(List list) {
    if (list.isEmpty()) {
      return null;
    } else {
      int middle = list.size() / 2;
      BinaryTreeNode node = new BinaryTreeNode(list.get(middle));
      node.setLeft(balanceTree(list.subList(0, middle)));
      node.setRight(balanceTree(list.subList(middle + 1, list.size())));
      return node;
    }
  }

}
