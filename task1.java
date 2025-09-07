import java.io.*;
import java.util.*;

public class FileOperations {

    // Method to write content into a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------\n");
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    // Method to modify file content (replace oldWord with newWord)
    public static void modifyFile(String fileName, String oldWord, String newWord) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            // Read the file and replace words
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll(oldWord, newWord);
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error while modifying file: " + e.getMessage());
            return;
        }

        // Write modified content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content.toString());
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing modified file: " + e.getMessage());
        }
    }

    // Main method to demonstrate file operations
    public static void main(String[] args) {
        String fileName = "sample.txt";

        // Step 1: Write content to file
        String content = "Hello World!\nThis is a Java File Operations Demo.\nLearning file handling in Java.";
        writeFile(fileName, content);

        // Step 2: Read the file
        readFile(fileName);

        // Step 3: Modify the file (replace word)
        modifyFile(fileName, "Java", "JAVA");
        
        // Step 4: Read again to see changes
        readFile(fileName);
    }
}
