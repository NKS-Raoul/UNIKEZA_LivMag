package com.example.livmag.data.repository

import com.example.livmag.data.network.BookDao
import com.example.livmag.domain.model.Book
import com.example.livmag.domain.repository.BookRepository

class BookRepositoryImpl(
    private val bookDao: BookDao
) : BookRepository {
    override fun getBooksFromRoom() = bookDao.getBooks()

    override fun getBookFromRoom(id: Int) = bookDao.getBook(id)

    override fun addBookToRoom(book: Book) = bookDao.addBook(book)

    override fun updateBookInRoom(book: Book) = bookDao.updateBook(book)

    override fun deleteBookFromRoom(book: Book) = bookDao.deleteBook(book)
}