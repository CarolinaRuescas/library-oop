package org.ies.library.model;

import java.util.Arrays;
import java.util.Objects;

public class Library {
    private String name;
    private Book[] books;

    public Library(String name, Book[] books) {
        this.name = name;
        this.books = books;
    }

    // hasBook(isbn): dado un ISBN devuelve si el libro existe en la biblioteca
    public Book hasBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // esta es la forma de hacerlo largo, pero en la de abajo se hace de tal forma que utilizamos el método
    // creado anteriormente en BOOK.

    // hasAuthor(authorNif): dado un NIF devuelve si hay algún libro de ese autor
    // public boolean hasAuthor(String nif) {
    //for (Book book : books) {
    // for (Author author : book.getAuthors()){
    //   if (author.getNif().equals(nif)){
    //  return true;
    //}
    // }
    //   }
    //   return false;
    //}

    public boolean hasAuthor(String nif) {
        for (Book book : books) {
            if (book.hasAuthor(nif)) {
                return true;
            }
        }
        return false;
    }

    // countBooks(authroNif):  dado un NIF devuelve el número de libros del autor
    public int countBooks(String nif) {
        int count = 0;
        for (Book book : books) {
            if (book.hasAuthor(nif)) {
                count++;
            }
        }
        return count;
    }

    //  countYearBooks(year): dado un año, devuelve el número de libros de ese año.
    public int countYearBooks(int year){
        int count = 0;
        for (Book book : books){
            if(book.getYear() == (year)){
                count++;
            }
        }
        return count;
    }

    // findBook(isbn): dado un ISBN, devuelve el libro con ese ISBN. Si no lo encuentra, devuelve null
    public Book findBook (String isbn){
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.deepEquals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(books));
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
