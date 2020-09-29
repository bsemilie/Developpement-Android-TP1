package com.ismin.androidtp1

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class BookshelfUnitTest {
    private val theLordOfTheRings = Book(
        title = "The Lord of the Rings",
        author = "J. R. R. Tolkien",
        date = LocalDate.parse("1954-02-15", DateTimeFormatter.ISO_DATE)

    )

    private val theHobbit = Book(
        title = "The Hobbit",
        author = "J. R. R. Tolkien",
        date = LocalDate.parse("1937-09-21", DateTimeFormatter.ISO_DATE)
    )
    private val aLaRechercheDuTempsPerdu = Book(
        title = "À la recherche du temps perdu",
        author = "Marcel Proust",
        date = LocalDate.parse("1927-01-01", DateTimeFormatter.ISO_DATE)
    );

    private lateinit var bookshelf: Bookshelf

    @Before
    fun setup() {
        bookshelf = Bookshelf()
    }

    @Test
    fun getBook_returns_stored_book() {
        bookshelf.addBook(theLordOfTheRings);

        assertEquals(bookshelf.getBook("The Lord of the Rings"), theLordOfTheRings)
    }

    @Test
    fun getAllBooks_returns_all_stored_books() {
        bookshelf.addBook(theLordOfTheRings);
        bookshelf.addBook(theHobbit);
        bookshelf.addBook(aLaRechercheDuTempsPerdu);

        assertEquals(
            bookshelf.getAllBooks(),
            arrayListOf(theHobbit, theLordOfTheRings, aLaRechercheDuTempsPerdu)
        )
    }

    @Test
    fun getBooksOf_returns_all_books_with_input_author() {
        bookshelf.addBook(theLordOfTheRings);
        bookshelf.addBook(theHobbit);
        bookshelf.addBook(aLaRechercheDuTempsPerdu);

        assertEquals(
            bookshelf.getBooksOf("J. R. R. Tolkien"),
            arrayListOf(theLordOfTheRings, theHobbit)
        )
    }

    @Test
    fun getTotalNumberOfBooks_returns_number_of_stored_books() {
        bookshelf.addBook(theLordOfTheRings);
        bookshelf.addBook(theHobbit);
        bookshelf.addBook(aLaRechercheDuTempsPerdu);

        assertEquals(bookshelf.getTotalNumberOfBooks(), 3)
    }

    @Test
    fun should_not_duplicate_a_book_already_stored() {
        bookshelf.addBook(theLordOfTheRings);
        assertEquals(bookshelf.getTotalNumberOfBooks(), 1)

        bookshelf.addBook(theLordOfTheRings);
        assertEquals(bookshelf.getTotalNumberOfBooks(), 1)
    }

    @Test
    fun should_return_all_books_published_before_1938() {
        bookshelf.addBook(aLaRechercheDuTempsPerdu);
        bookshelf.addBook(theLordOfTheRings);
        bookshelf.addBook(theHobbit);

        assertEquals(
            bookshelf.getBooksPublishedBefore(
                LocalDate.parse(
                    "1938-01-01",
                    DateTimeFormatter.ISO_DATE
                )
            ),
            arrayListOf(aLaRechercheDuTempsPerdu, theHobbit)
        );

    }
}