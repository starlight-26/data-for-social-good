import java.util.Scanner;

public class UserStory {

  private int[] bpm;               // An array of BPMs of the most popular songs
  private int[] danceability;      // An array of danceability % of the most popular songs
  private int[] valence;           // An array of valence % of the most popular songs
  private int[] energy;            // An array of energy % of the most popular songs
  private int[] speechiness;       // An array of speechiness % of the most popular songs

  
  /* 
  * Assign values to each instance variable
  */ 
  public UserStory() {
    bpm = FileReader.toIntArray("bpm.txt");
    danceability = FileReader.toIntArray("danceability.txt");
    valence = FileReader.toIntArray("valence.txt");
    energy = FileReader.toIntArray("energy.txt");
    speechiness = FileReader.toIntArray("speechiness.txt");
  }

  
  /* 
  * Returns the total of every number in an array
  */
  public double getTotal(int[] array) {
    // Creates a results variable
    double results = 0;

    // Traverses an array and adds each element to the results varible
    for (int i = 0; i < array.length; i++) {
      results += array[i];
    }  

    // Returns results
    return results;
  }

  /* 
  * Returns the average of every number in an array
  */
  public double getAverage(int[] array) {
    // Creates a total variable and 
    // assigns its value by calling the getTotal() method
    double total = getTotal(array);

    // Creates a results varible and 
    // assigns its value as the total divided by the length of the array
    double results = total / array.length;

    // Returns results
    return results;
  }

  /* 
  * Gives the user information depending on their choices
  */
  public void promptUser() {
    int choice = 1;

    while (!(choice == 2)) {
      int option = promptOption();
      String text = "";

      // Depending on the user's choice, assigns a value to the text varible
      if (option == 1) {
        text = String.format("%.2f", getAverage(bpm));
      } else if (option == 2) {
        text = String.format("%.2f", getAverage(danceability)) + "%";
      } else if (option == 3) {
        text = String.format("%.2f", getAverage(valence)) + "%";
      } else if (option == 4) {
        text = String.format("%.2f", getAverage(energy)) + "%";
      } else if (option == 5) {
        text = String.format("%.2f", getAverage(speechiness)) + "%";
      }

      // Prints out text
      System.out.println("\n" + text);

      choice = promptContinue();
    }

    // Ending message
    System.out.println("\nThank You");
  }

  /* 
  * Asks the user for their selection
  */
  public int promptOption() {
    // Creates a Scanner object
    Scanner input = new Scanner(System.in);

    // Asks the user what they would like to do
    System.out.println("\nWhich average would you like to know?");
    System.out.println("1. BPM");
    System.out.println("2. Danceablity");
    System.out.println("3. Valence");
    System.out.println("4. Energy");
    System.out.println("5. Speechiness");

    // Gets the user's selection
    int option = input.nextInt();
    input.nextLine();

    // Closes the Scanner object
    input.close();

    // Returns option
    return option;
  }

  /* 
  * Asks the user if they would like the program to continue
  */
  public int promptContinue() {
    // Creates a Scanner object
    Scanner input = new Scanner(System.in);

    // Asks the user if they would like to continue
    System.out.println("\nContinue?");
    System.out.println("1. Yes");
    System.out.println("2. No");

    // Gets the user's choice
    int choice = input.nextInt();
    input.nextLine();

    // Closes the Scanner object
    input.close();

    // Returns choice
    return choice;
  }
  

  /* 
  * toString Method Override
  */
  public String toString() {
    // Formats each number to only have two decimal places
    String bpmText = String.format("%.2f", getAverage(bpm));
    String danceText = String.format("%.2f", getAverage(danceability));
    String valenceText = String.format("%.2f", getAverage(valence));
    String energyText = String.format("%.2f", getAverage(energy));
    String speechText = String.format("%.2f", getAverage(speechiness));

    // Returns the text to be printed into the console
    return "Averages for the Most Popular Songs:"
      + "\nBPM: " + bpmText 
      + "\nDanceablity: " + danceText
      + "%\nValence: " + valenceText
      + "%\nEnergy: " + energyText
      + "%\nSpeechiness: " + speechText + "%";
  }

}