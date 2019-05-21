import java.io.*;

/**
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 * @author Mohammad Chaudhry
 * Student Number: T00554758
 */
public class BackPainAnalyzer
{
	/**
	 *  Asks questions of the user to diagnose a medical problem. Additionally three other traversals are simulated.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, you're having back pain.\n");

		DecisionTree expert = new DecisionTree("input.txt");
//		Uses user input to traverse the DecisionTree
		expert.evaluate();
		System.out.println();

//		Simulates user input to traverse the DecisionTree as shown in listing 19.6 from the textbook
		System.out.println("\n\nSimulated user input as shown in listing 19.6 from the textbook");
		expert.testlistingOutput();

//		Simulates user input to always traverse left node in the DecisionTree
		System.out.println("\n\nSimulated user input such that the left most node is reached");
		expert.testleftTraversal();

//		Simulates user input to traverse traverse DecisionTree in such a way that the following leaf node reached is:
//		"You may have a respiratory infection."
		System.out.println("\n\nSimulated user input such that the following node is reached \"You may have a respiratory infection.\"'");
		expert.testRespiratoryTraversal();

	}

}
