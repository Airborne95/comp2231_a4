import jsjf.*;
import java.util.*;
import java.io.*;

/**
 * The DecisionTree class uses the LinkedBinaryTree class to implement 
 * a binary decision tree. Tree elements are read from a given file and  
 * then the decision tree can be evaluated based on user input using the
 * evaluate method. 
 *
 * @author Java Foundations
 * @author Mohammad Chaudhry
 * Student Number: T00554758
 * @version 4.0
 */
public class DecisionTree
{
    private LinkedBinaryTree<String> tree;

    /**
     * Builds the decision tree based on the contents of the given file
     *
     * @param filename the name of the input file
     * @throws FileNotFoundException if the input file is not found
     */
    public DecisionTree(String filename) throws FileNotFoundException
    {
        File inputFile = new File(filename);
        Scanner scan = new Scanner(inputFile);
        int numberNodes = scan.nextInt();
        scan.nextLine();
        int root = 0, left, right;

        List<LinkedBinaryTree<String>> nodes = new java.util.ArrayList<LinkedBinaryTree<String>>();

        for (int i = 0; i < numberNodes; i++)
            nodes.add(i, new LinkedBinaryTree<String>(scan.nextLine()));

        while (scan.hasNext())
        {
            root = scan.nextInt();
            left = scan.nextInt();
            right = scan.nextInt();
            scan.nextLine();

            nodes.set(root, new LinkedBinaryTree<String>((nodes.get(root)).getRootElement(),
                    nodes.get(left), nodes.get(right)));
        }
        tree = nodes.get(root);
    }

    /**
     *  Follows the decision tree based on user responses.
     */
    public void evaluate()
    {
        LinkedBinaryTree<String> current = tree;
        Scanner scan = new Scanner(System.in);

        while (current.size() > 1)
        {
            System.out.println(current.getRootElement());
            if (scan.nextLine().equalsIgnoreCase("N"))
                current = current.getLeft();
            else
                current = current.getRight();
        }
        System.out.println(current.getRootElement());
    }

    /**
     *  Simulates traversal of the decision tree based on Listing 19.6 found on page 746 of the textbook.
     */
    public void testlistingOutput(){
        LinkedBinaryTree<String> current = tree;

//        First (Root Node) Question is printed out to provide a visual of the simulation
//        Simulated User input is printed
        System.out.println(current.getRootElement());
        System.out.println("User Input: Y");

//        Traverse to the right node because the simulated User entered "Y".
//        Print out the right node and simulated user input
        current=current.getRight();
        System.out.println(current.getRootElement());
        System.out.println("User Input: N");

//        Traverse to the left node because the simulated User entered "N".
//        Print out the left node and simulated user input
        current=current.getLeft();
        System.out.println(current.getRootElement());
        System.out.println("User Input: Y");

//        Traverse to the right node because the simulated User entered "Y".
//        Print out the right node only because it is the leaf node
        current=current.getRight();
        System.out.println(current.getRootElement());
    }

    /**
     *  Simulates traversal of the decision tree along the left subtree.
     *  In this case, the user always respond with a No making the traversal always move towards the left subtree.
     */
    public void testleftTraversal(){
        LinkedBinaryTree<String> current = tree;

//        First (Root Node) Question is printed out to provide a visual of the simulation
//        Simulated User input is printed
        System.out.println(current.getRootElement());
        System.out.println("User Input: N");

//        Traverse to the left node because the simulated User entered "N".
//        Print out the left node and simulated user input
        current=current.getLeft();
        System.out.println(current.getRootElement());
        System.out.println("User Input: N");

//        Traverse to the left node because the simulated User entered "N".
//        Print out the left node and simulated user input
        current=current.getLeft();
        System.out.println(current.getRootElement());
        System.out.println("User Input: N");

//        Traverse to the left node because the simulated User entered "N".
//        Print out the left node only because it is the leaf node
        current=current.getLeft();
        System.out.println(current.getRootElement());
    }

    /**
     *  Simulates traversal of the decision tree such that the
     *  decision states: "You may have a respiratory infection."
     */
    public void testRespiratoryTraversal(){
        LinkedBinaryTree<String> current = tree;

//        First (Root Node) Question is printed out to provide a visual of the simulation
//        Simulated User input is printed
        System.out.println(current.getRootElement());
        System.out.println("User Input: N");

//        Traverse to the left node because the simulated User entered "N".
//        Print out the left node and simulated user input
        current=current.getLeft();
        System.out.println(current.getRootElement());
        System.out.println("User Input: Y");

//        Traverse to the right node because the simulated User entered "Y".
//        Print out the right node and simulated user input
        current=current.getRight();
        System.out.println(current.getRootElement());
        System.out.println("User Input: Y");

//        Traverse to the right node because the simulated User entered "Y".
//        Print out the right node only because it is the leaf node
        current=current.getRight();
        System.out.println(current.getRootElement());
    }
}