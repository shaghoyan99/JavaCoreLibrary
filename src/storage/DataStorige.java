package storage;


import modul.Book;

public class DataStorige {

    public Book[] books = new Book[10];
    private int size;

    public void add(Book value) {
        if (size == books.length) {
            extend();
        }
        books[size++] = value;
    }

    private void extend() {
        Book[] tmp = new Book[books.length + 10];
        System.arraycopy(books,0,tmp,0,books.length);
        books =tmp;
    }

    public Book getByIndex(int index) {
        if (index >= 0 && index < size) {
            return books[index];
        }
        return null;
    }

    public Book getBookByTitle(String search) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(search)) {
                return books[i];
            }
        }
        return null;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(books[i] + " ");
        }
        System.out.println();
    }


}
