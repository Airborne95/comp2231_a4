import java.io.*;

/**
 * ....
 *
 * @author Mohammad Chaudhry
 * Student Number: T00554758
 */
public class BruteBalanceDriver {

  /**
   *  Balances and unbalanced tree
   */
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Brute Balance Test =).\n");
    BruteBalance balancingTree = new BruteBalance("unbalancedInput.txt");

//    Allows user to traverse the unbalanced tree
    balancingTree.evaluate();
    System.out.println();

    balancingTree.balance();

//    Allows user to traverse the balanced tree
    balancingTree.evaluate();
  }
}
