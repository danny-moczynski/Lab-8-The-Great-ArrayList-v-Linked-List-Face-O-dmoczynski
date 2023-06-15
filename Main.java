import lab8.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    // Instantiate a new object
    PartA partA = new PartA();
    long time1 = partA.arrayListEfficientReversal("100-space-delimited-words.txt", "reverse.txt");
    long time2 = partA.arrayListInefficientReversal("100-space-delimited-words.txt", "reverse.txt");
    long time3 = partA.linkedListEfficientReversal("100-space-delimited-words.txt", "reverse.txt");
    long time4 = partA.linkedListInefficientReversal("100-space-delimited-words.txt", "reverse.txt");
    long time5 = partA.dequeEfficientReversal("100-space-delimited-words.txt", "reverse.txt");
    // Print out the input file
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Input file (press return to select words.txt): ");
    String fileName = scanner.nextLine().trim();
    // Print out the output file
    System.out.printf("Output file (press return to select reversed.txt):");
    scanner.nextLine();

    
    System.out.println("Elapsed time for ArrayList efficient method: " + time1 + " ms");
    System.out.println("Elapsed time for ArrayList inefficient method: " + time2 + " ms");
    System.out.println("Elapsed time for LinkedList efficient method: " + time3 + " ms");
    System.out.println("Elapsed time for LinkedList inefficient method: " + time4 + " ms");
    System.out.println("Elapsed time for Deque efficient method: " + time5 + " ms");
    PartB.printWords();
  }
}
