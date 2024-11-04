import java.util.Scanner;

public class DataRunner {
  public static void main(String[] args) {

    /*
     * Testing objects
     */
    // Creates a Clothes object with no arguments
    UserStory test = new UserStory();

    // Prints out information about the test object
    System.out.println(test);

    System.out.println("\n-------------------------");

    // Calls on the promptUser() method
    test.promptUser();
    
    
  }
}