
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {

    public static void main(String[] args) {

        String fileName = "my_notes.txt";

        // Section 1: Writing to the file using FileWriter
        writeToFile(fileName);

        // Section 2: Reading from the file using BufferedReader and FileReader
        readFromFile(fileName);
    }

    /**
     * Writes predefined notes to a specified file.
     * @param fileName The name of the file to write to.
     */
    private static void writeToFile(String fileName) {
        // Using try-with-resources ensures the FileWriter is automatically closed.
        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("✍️ Writing to file: " + fileName);

            // Write content to the file
            writer.write("Hello! This is the first note.\n");
            writer.write("Java file I/O is straightforward.\n");
            writer.write("This is the final line.");

            System.out.println("✅ Successfully wrote to the file.");

        } catch (IOException e) {
            System.err.println("❌ An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Reads all lines from a specified file and prints them to the console.
     * @param fileName The name of the file to read from.
     */
    private static void readFromFile(String fileName) {
        // Using try-with-resources for automatic closing of reader resources.
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            System.out.println("\n📖 Reading from file: " + fileName);
            System.out.println("--- File Content ---");

            String currentLine;
            // Read the file line by line until the end is reached (readLine() returns null)
            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
            }
            System.out.println("--------------------");

        } catch (IOException e) {
            System.err.println("❌ An error occurred while reading the file: " + e.getMessage());
        }
    }
}