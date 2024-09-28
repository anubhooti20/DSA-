import java.util.*;
import java.io.*;
public class fileManagement{
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("File Management System Menu:");
            System.out.println("1. Create File");
            System.out.println("2. List Files");
            System.out.println("3. Read File");
            System.out.println("4. Update File");
            System.out.println("5. Delete File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createFile(scanner);
                    break;
                case 2:
                    listFiles();
                    break;
                case 3:
                    readFile(scanner);
                    break;
                case 4:
                    updateFile(scanner);
                    break;
                case 5:
                    deleteFile(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error occurred while creating the file: " + e.getMessage());
        }
    }

    private static void listFiles() {
        System.out.println("List of files in the current directory:");
        File currentDirectory = new File(".");
        File[] files = currentDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    private static void readFile(Scanner scanner) {
        System.out.print("Enter the file name to read: ");
        String fileName = scanner.nextLine();
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void updateFile(Scanner scanner) {
        System.out.print("Enter the file name to update: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter the new content: ");
        String content = scanner.nextLine();
        try {
            File file = new File(fileName);
            java.nio.file.Files.write(file.toPath(), content.getBytes());
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while updating the file: " + e.getMessage());
        }
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file. File may not exist.");
        }
    }
}