

import modul.Book;
import storage.DataStorige;

import java.util.Scanner;

public class BookTest {
    static Scanner scanner = new Scanner(System.in);
    static DataStorige dataStorige = new DataStorige();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            showCommand();
            String command = scanner.nextLine();
            switch (command) {
                case Commands.EXIT:
                    isRun = false;
                    break;
                case Commands.ADD_BOOK:
                    addbook();
                    break;
                case Commands.SEARCH_BY_TITLE:
                    searchBookByTitle();
                    break;
                default:
                    System.out.println("Wrong command! ");
            }
        }
    }

    private static void showCommand() {
        System.out.println("Please input " + Commands.EXIT + " for exit.");
        System.out.println("Please input " + Commands.ADD_BOOK + " for ADD BOOK.");
        System.out.println("Please input " + Commands.SEARCH_BY_TITLE + " for SEARCH BOOK BY TITLE.");
    }

    private static void addbook() {
        System.out.println("Please input Book data");
        System.out.print("Title։ ");
        String title = scanner.nextLine();
        System.out.print("AutherName։ ");
        String autherName = scanner.nextLine();
        System.out.print("Price։ ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Count։ ");
        int count = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title, autherName, price, count);
        dataStorige.add(book);
        System.out.println("Book was added");
    }

    private static void searchBookByTitle() {
        System.out.println("Please input title for search");
        String searchTitle = scanner.nextLine();
        Book searchedBook = dataStorige.getBookByTitle(searchTitle);
        if (searchedBook == null) {
            System.out.println("Book with " + searchTitle + "titel does not exists");
        } else {
            System.out.println(searchedBook);
        }
    }
}
