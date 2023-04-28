import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
* This program gets input from a text file and
* performs a Binary search by sorting the numbers
* and cutting the array in half each time.
*
* @author Logan S
* @version 1.0
* @since 2023-04-27
*/

public final class RecBin {

    /**
    * For linter.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */

    private RecBin() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */

    public static void main(String[] args) {
        try {
            // Create scanner and read from input.txt
            final Scanner scanner = new Scanner(new File("input.txt"));

            // Create FileWriter to output results to output.txt
            final FileWriter fileWriter = new FileWriter(new File(
                    "output.txt"));

            // Read through each of the 10 groupings of 2 lines each
            for (int i = 0; i < 10; i++) {
                // Read the first line of random numbers
                final String[] randomNumsStr = scanner.nextLine().split(" ");
                final int[] randomNums = new int[randomNumsStr.length];

                // Convert the random number strings to integers
                for (int j = 0; j < randomNumsStr.length; j++) {
                    randomNums[j] = Integer.parseInt(randomNumsStr[j]);
                }

                // Read the second line containing the search number
                final int searchNum = scanner.nextInt();
                // Move scanner to next line
                scanner.nextLine();

                // Sort array
                Arrays.sort(randomNums);

                /*
                * Call the RecBinSearch function to find the
                * index of the search number
                */
                final int result = recBinSearch(randomNums, searchNum, 0,
                        randomNums.length);

                // Output the result to output.txt
                fileWriter.write(result + "\n");
            }

            // Close the Scanner and FileWriter
            scanner.close();
            fileWriter.close();
        } catch (IOException exception) {
            exception.getMessage();
        }
    }

    /**
    * This is the main method.
    *
    * @param listOfNum List of numbers.
    * @param searchNum Number searched.
    * @param start Start.
    * @param end End.
    * @return The index.
    */
    // Function to perform recursive binary search on a list of numbers
    public static int recBinSearch(int[] listOfNum, int searchNum,
            int start, int end) {

        // Find the middle index
        final int mid = (start + end) / 2;

        // If the search number is found at the middle index, return the index
        if (listOfNum[mid] == searchNum) {
            return mid;
        } else if (searchNum > listOfNum[mid]) {
            // If the search number is greater than the middle value,
            // search the right half of the list
            return recBinSearch(listOfNum, searchNum, mid + 1, end);
        } else if (searchNum < listOfNum[mid]) {
            // If the search number is less than the middle value,
            // search the left half of the list
            return recBinSearch(listOfNum, searchNum, start, mid - 1);
        } else {
            // If the search number is not found, return -1
            return -1;
        }
    }
}
