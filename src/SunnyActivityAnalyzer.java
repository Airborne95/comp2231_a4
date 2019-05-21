import java.io.*;

/**
 * ....
 * @author Mohammad Chaudhry
 * Student Number: T00554758
 */
public class SunnyActivityAnalyzer {

    /**
     *  Asks user a list of questions to suggest an activity.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("So, cant figure out what to do today? Take this short quiz!\n");
        DecisionTree expert = new DecisionTree("summerinput.txt");

//		Uses user input to traverse the Summer Activity Tree
		expert.evaluate();

    }
}
