import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean available;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println("----------------------");
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        books.add(new Book("Java Programming", "James Gosling"));
        books.add(new Book("Database Systems", "Elmasri"));

        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Book title: ");
                    String title = input.nextLine();

                    System.out.print("Author: ");
                    String author = input.nextLine();

                    books.add(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;


                case 2:
                    for (Book book : books) {
                        book.displayBook();
                    }
                    break;


                case 3:
                    System.out.print("Enter book title: ");
                    String search = input.nextLine();

                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(search)) {
                            book.displayBook();
                        }
                    }
                    break;


                case 4:
                    System.out.print("Enter book title to borrow: ");
                    String borrow = input.nextLine();

                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(borrow)
                                && book.available) {
                            book.available = false;
                            System.out.println("Book borrowed!");
                        }
                    }
                    break;


                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnBook = input.nextLine();

                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(returnBook)) {
                            book.available = true;
                            System.out.println("Book returned!");
                        }
                    }
                    break;


                case 0:
                    System.out.println("Goodbye!");
                    break;


                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);


        input.close();
    }
}