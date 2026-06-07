package com.collage.application.pl;

import com.collage.application.library.dao.LibraryDAOImpl;
import com.collage.application.library.model.LibraryModel;

import java.util.List;
import java.util.Scanner;

public class LibraryController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryDAOImpl dao = new LibraryDAOImpl();

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();

                    dao.createBook(new LibraryModel(id, title, author, copies));
                }
                case 2 -> {
                    List<LibraryModel> books = dao.getAllBooks();
                    books.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter Book Title to search: ");
                    String title = sc.nextLine();
                    LibraryModel book = dao.searchBookByTitle(title);
                    System.out.println(book != null ? book : "⚠️ Book not found!");
                }
                case 4 -> {
                    System.out.print("Enter Book ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter New Available Copies: ");
                    int copies = sc.nextInt();

                    dao.updateBook(new LibraryModel(id, title, author, copies));
                }
                case 5 -> {
                    System.out.print("Enter Book ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteBook(id);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
