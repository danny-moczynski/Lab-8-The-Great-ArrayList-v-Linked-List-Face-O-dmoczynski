package lab8;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PartA {
  private ArrayList<String> words = new ArrayList<>();

  // Iterating through an arraylist efficiently would come random access and when
  // used for adding or removing elements at the end of the list (constant time)
  public long arrayListEfficientReversal(String inputFileName, String outputFileName) {
    long startTime = System.currentTimeMillis();
    // Open the file for reading
    try {
      Scanner scanner = new Scanner(new File(inputFileName));
      // Read it into an ArrayList<>, in as efficient a way as possible
      while (scanner.hasNext()) {
        words.add(scanner.next());
      }
      // Close the scanner
      scanner.close();

      // Write it
      PrintWriter pw = new PrintWriter(new FileOutputStream(outputFileName));
      // Write the words to the output file in reverse order
      for (int i = words.size() - 1; i >= 0; i--) {
        pw.print(words.get(i) + " ");
      }
      // Close the printwriter
      pw.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found" + fnfe.getMessage());
    }

    // return the elapsed time
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  // Iterating through an arraylist inefficiently would involve repeatedly
  // adding elements to the beginning of the arraylist, which would involve
  // shifting all the remaining elements each time

  // Start at index 0 and and from 0
  public long arrayListInefficientReversal(String inputFileName, String outputFileName) {
    long startTime = System.currentTimeMillis();

    // Open the file for reading
    try {
      Scanner scanner = new Scanner(new File(inputFileName));

      // Read it into an ArrayList<>, in as efficient a way as possible
      while (scanner.hasNext()) {
        words.add(0, scanner.next());
      }
      // Close the scanner
      scanner.close();

      // Write it
      PrintWriter pw = new PrintWriter(outputFileName);
      // Write the words to the output file in reverse order
      for (String word : words) {
        pw.print(word + " ");
      }
      // Close the printwriter
      pw.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found" + fnfe.getMessage());
    }

    // return the elapsed time
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  // A linkedlist can be efficient when used for inserting or removing elements at
  // the beginning or in the middle of the list
  public long linkedListEfficientReversal(String inputFileName, String outputFileName) {
    long startTime = System.currentTimeMillis();

    // Open the file for reading
    try {
      Scanner scanner = new Scanner(new File(inputFileName));

      // Read it into a LinkedList<>, in as efficient a way as possible
      LinkedList<String> words = new LinkedList<>();
      while (scanner.hasNext()) {
        words.add(scanner.next());
      }
      // Close the scanner
      scanner.close();

      // Write it
      PrintWriter pw = new PrintWriter(outputFileName);
      // Write the words to the output file in reverse order
      // The ListIterator reads the file as a size and checks whether there is a word
      // to the previous word it is checking, if that is true, it prints out the
      // previous words and checks again
      ListIterator<String> LI = words.listIterator(words.size());
      while (LI.hasPrevious()) {
        pw.print(LI.previous() + " ");
      }
      // Close the printwriter
      pw.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found" + fnfe.getMessage());
    }

    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  // A linkedlist can be inefficient when trying to access random variables (not
  // constant time)
  public long linkedListInefficientReversal(String inputFileName, String outputFileName) {
    long startTime = System.currentTimeMillis();
    LinkedList<String> words = new LinkedList<>();
    try {
      // Read the linkedlist in
      Scanner scanner = new Scanner(new File(inputFileName));
      while (scanner.hasNext()) {
        words.add(scanner.next());
      }
      scanner.close();
      // Write the linkedlist to the output file
      PrintWriter pw = new PrintWriter(outputFileName);
      // Write the words to the output file reversely
      for (String word : words) {
        pw.print(word + " ");
      }
      // Close the printwriter
      pw.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found " + fnfe.getMessage());
    }
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public long dequeEfficientReversal(String inputFileName, String outputFileName) {
    long startTime = System.currentTimeMillis();

    // Open the file for reading
    try {
      Scanner scanner = new Scanner(new File(inputFileName));

      // Read it into a Deque<>, in as efficient a way as possible
      Deque<String> words = new ArrayDeque<>();
      while (scanner.hasNext()) {
        words.add(scanner.next());
      }
      // Close the scanner
      scanner.close();

      // Write it
      PrintWriter pw = new PrintWriter(outputFileName);
      // Write the words to the output file in reverse order
      while (!words.isEmpty()) {
        pw.print(words.removeLast() + " ");
      }
      // Close the printwriter
      pw.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found" + fnfe.getMessage());
    }

    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }
}
