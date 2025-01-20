import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File Handling Utility!");
        System.out.println("Choose an operation:");
        System.out.println("1. Read a file");
        System.out.println("2. Write to a file");
        System.out.println("3. Modify a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String defaultFilePath = "file_handling_demo.txt";

        switch (choice) {
            case 1:
                System.out.println("Using default file: " + defaultFilePath);
                readFile(defaultFilePath);
                break;
            case 2:
                System.out.println("Enter the text to write:");
                String content = scanner.nextLine();
                writeFile(defaultFilePath, content);
                break;
            case 3:
                System.out.println("Enter the text to append:");
                String newContent = scanner.nextLine();
                modifyFile(defaultFilePath, newContent);
                break;
            default:
                System.out.println("Invalid choice! Exiting.");
        }

        scanner.close();
    }

    public static void readFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    
    public static void modifyFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
