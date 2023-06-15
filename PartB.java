package lab8;

import java.util.*;
import java.io.*;

public class PartB {
  /*
   * Method: This method prompts the user for a file name and called the
   * countWords method for the filename
   *
   */
  public static void printWords() {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Input file (press return to select words.txt): ");
    String fileName = scanner.nextLine().trim();

    countWords(fileName);
    scanner.close();
  }

  /*
   * Method: This method reads a file specified by the inputFileName parameter and
   * counts the number of words in the file, along with the number of unique
   * words. It then prompts the user to enter a word and displays the count of
   * that word in the file.
   *
   * @return: inputFileName that is a string
   */
  public static void countWords(String inputFileName) {
    Map<String, Integer> wordCounts = new HashMap<>();
    int totalWords = 0;
    int totalUniqueWords = 0;
    boolean anotherWord = true;

    try {
      Scanner scanner = new Scanner(new File(inputFileName));
      scanner.useDelimiter("[\\p{Punct}\\(\\)\\s“”]"); // Use custom delimiters
      while (scanner.hasNext()) {
        // Scan in each word and set it to lowercase
        String word = scanner.next().toLowerCase();
        // The getOrDefault method looks up the current word and either returns it as 0
        // if it is not found or 1 if it is found
        int count = wordCounts.getOrDefault(word, 0) + 1;
        // The put method takes in the current word and what value to store into the map
        wordCounts.put(word, count);
        totalWords++;
        // If a word only exists once, it is unique
        if (count == 1) {
          totalUniqueWords++;
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: file not found");
      return;
    }
    // Print the total number of words and total number of unique words
    System.out.println("Total # of words: " + totalWords);
    System.out.println("Total # of unique words: " + totalUniqueWords);

    while (anotherWord) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("word: ");
      String input = scanner.nextLine().toLowerCase().trim();
      if (input.isEmpty()) {
        break;
      }
      // Check if the input value of the user is in the input file, if not, 0 is
      // returned
      int count = wordCounts.getOrDefault(input, 0);
      System.out.printf("count: %d\n", count);
    }

  }
}
