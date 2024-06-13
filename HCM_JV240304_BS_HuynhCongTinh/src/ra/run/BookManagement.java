package ra.run;

import ra.business.Book;
import java.util.Scanner;

public class BookManagement {
    private static Book[] books = new Book[100];
    private static int count = 0;

    public static void addBooks(Scanner scanner) {
        System.out.print("Enter number of books to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (count + n > 100) {
            System.out.println("Cannot add more than 100 books.");
            return;
        }

        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData();
            books[count++] = book;
        }
    }

    public static void displayAllBooks() {
        for (int i = 0; i < count; i++) {
            books[i].displayData();
            System.out.println("-----------------------------");
        }
    }

    public static void sortBooksByInterest() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Books sorted by interest.");
    }

    public static void deleteBookById(Scanner scanner) {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--count] = null;
                System.out.println("Book with ID " + id + " deleted.");
                return;
            }
        }
        System.out.println("Book with ID " + id);
    }

    public static void searchBooks(Scanner scanner) {
        System.out.print("Enter search term: ");
        String term = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookName().contains(term) || books[i].getDescriptions().contains(term)) {
                books[i].displayData();
                System.out.println("-----------------------------");
            }
        }
    }

    public static void updateBookById(Scanner scanner) {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].inputData();
                System.out.println("Book with ID " + id + " updated.");
                return;
            }
        }
        System.out.println("Book with ID " + id);
    }
}
