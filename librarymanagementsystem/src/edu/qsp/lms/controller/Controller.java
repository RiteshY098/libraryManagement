package edu.qsp.lms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.qsp.lms.model.Book;
import edu.qsp.lms.model.Library;

public class Controller {
	private Library library = new Library(); // create a library object

	public void addBook(Book book) {
		List<Book> books = library.getBooks(); // get the list of books from the library
		if (books == null) { // if the list is null, create a new list
			books = new ArrayList<Book>();
			library.setBooks(books); // set the list to the library
		}
		books.add(book); // add the book to the list
	}

	public Book searchBook(String bookName) {
		List<Book> books = library.getBooks(); // get the list of books from the library
		//
		Iterator<Book> iterator = books.iterator(); // create an iterator to traverse the list
		while (iterator.hasNext()) { // while there is a next element in the list
			Book book = iterator.next(); // get the next book
			if (book.getBookName().equalsIgnoreCase(bookName)) { // if the book name matches the given name, ignoring case
				return book; // return the book
			}
		}
		return null; // if no book is found, return null
	}

	public boolean removeBook(String bookName) {
		Book book = searchBook(bookName); // search for the book by name
		if (book != null) { // if the book is found
			List<Book> books = library.getBooks(); // get the list of books from the library
			books.remove(book); // remove the book from the list
			return true; // return true to indicate success
		}
		return false; // if the book is not found, return false to indicate failure
	}

	public boolean updateBookPriceByBookName(Book refBook) {
		Book book = searchBook(refBook.getBookName()); // search for the book by name
		if (book != null) { // if the book is found
			book.setBookPrice(refBook.getBookPrice()); // update the book price with the given price
			return true; // return true to indicate success
		}
		return false; // if the book is not found, return false to indicate failure
	}

	public List<Book> getAllBooks() {
		return library.getBooks(); // return the list of books from the library

	}

}
