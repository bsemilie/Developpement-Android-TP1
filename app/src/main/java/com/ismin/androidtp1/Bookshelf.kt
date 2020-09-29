package com.ismin.androidtp1

import java.time.LocalDate

class Bookshelf {

    val bookshelf: ArrayList<Book?>;

    constructor() {
        this.bookshelf = arrayListOf<Book?>();
    }

    fun addBook(book: Book) {
        if (this.bookshelf.isEmpty()) {
            this.bookshelf.add(book);
        } else {
            for (i in 0 until this.bookshelf.size) {
                if (this.bookshelf[i]?.title.equals(book.title)) {
                    return;
                }
            }
            this.bookshelf.add(book);
        }
    }

    fun getBook(title: String): Book? {
        var lclBook: Book?;
        lclBook = null;

        for (i in 0 until this.bookshelf.size) {
            if (this.bookshelf[i]?.title.equals(title)) {
                lclBook = this.bookshelf[i];
            }
        }
        return lclBook;
    }

    private fun selectorSort(book: Book?): String? = book?.title

    fun getAllBooks(): ArrayList<Book?> {
        this.bookshelf.sortBy { selectorSort(it) };
        return (this.bookshelf);
    }

    private fun selectorFilterAuthor(book: Book?): String? = book?.author

    fun getBooksOf(author: String): List<Book?> {
        val lclBookshelf = this.bookshelf.filter { selectorFilterAuthor(it) == author };
        return lclBookshelf;
    }


    fun getTotalNumberOfBooks(): Int {
        return this.bookshelf.size;
    }

    private fun selectorFilterDate(book: Book?): LocalDate? = book?.date

    fun getBooksPublishedBefore(adate: LocalDate): List<Book?> {
        val lclBookshelf = this.bookshelf.filter { selectorFilterDate(it)!! <= adate };
        return lclBookshelf;
    }
}
