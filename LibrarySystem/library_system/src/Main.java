import Client.*;
import CustomException.*;
import Library.*;
import Management.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        ClientManagement clientManagement = new ClientManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Clients");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manageLibraryItems(libraryManagement, scanner);
                        break;
                    case 2:
                        manageClients(clientManagement, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting... Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void manageLibraryItems(LibraryManagement libraryManagement, Scanner scanner) {
        while (true) {
            System.out.println("\nManage Library Items");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Retrieve Item by ID");
            System.out.println("4. Update Item");
            System.out.println("5. Remove Item");
            System.out.println("6. Display All Items");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Enter book ID: ");
                        int bookID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        Book book = new Book();
                        book.setTitle(bookTitle);
                        book.setID(bookID);
                        book.setAuthor(author);
                        libraryManagement.addItem(book);
                        System.out.println("Book added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter magazine title: ");
                        String magTitle = scanner.nextLine();
                        System.out.print("Enter magazine ID: ");
                        int magID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter issue number: ");
                        int issueNum = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Magazine magazine = new Magazine();
                        magazine.setTitle(magTitle);
                        magazine.setID(magID);
                        magazine.setIssueNumber(issueNum);
                        libraryManagement.addItem(magazine);
                        System.out.println("Magazine added successfully.");
                        break;
                    case 3:
                        System.out.print("Enter item ID to retrieve: ");
                        int retrieveID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            libraryManagement.displayItems(); // Display all items (or specific logic can be added).
                        } catch (ItemNotFound e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Update functionality not implemented yet."); // Placeholder
                        break;
                    case 5:
                        System.out.print("Enter item ID to remove: ");
                        int removeID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            libraryManagement.removeItem(removeID);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        libraryManagement.displayItems();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (EmptyString | RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ItemNotFound e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void manageClients(ClientManagement clientManagement, Scanner scanner) {
        while (true) {
            System.out.println("\nManage Clients");
            System.out.println("1. Add Client");
            System.out.println("2. Retrieve Client by ID");
            System.out.println("3. Update Client");
            System.out.println("4. Remove Client");
            System.out.println("5. Display All Clients");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter client name: ");
                        String clientName = scanner.nextLine();
                        System.out.print("Enter client ID: ");
                        int clientID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter client email: ");
                        String clientEmail = scanner.nextLine();
                        Client client = new Client(clientID, clientName, clientEmail);
                        clientManagement.addClient(client);
                        System.out.println("Client added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter client ID to retrieve: ");
                        int retrieveID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            clientManagement.displayClients();
                        } catch (ItemNotFound e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Update functionality not implemented yet."); // Placeholder
                        break;
                    case 4:
                        System.out.print("Enter client ID to remove: ");
                        int removeID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            clientManagement.removeClient(removeID);
                        } catch (ItemNotFound e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        clientManagement.displayClients();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (EmptyString | RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ItemNotFound e) {
                throw new RuntimeException(e);
            }
        }
    }
}
