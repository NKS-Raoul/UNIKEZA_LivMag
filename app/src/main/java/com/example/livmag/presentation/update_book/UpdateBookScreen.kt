package com.example.livmag.presentation.update_book

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.livmag.domain.model.Book
import com.example.livmag.presentation.books.BooksViewModel
import com.example.livmag.presentation.update_book.components.UpdateBookContent
import com.example.livmag.presentation.update_book.components.UpdateBookTopBar

@Composable
fun UpdateBookScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    bookId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getBook(bookId)
    }
    Scaffold(
        topBar = {
            UpdateBookTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateBookContent(
                padding = padding,
                book = viewModel.book,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateAuthor = { author ->
                    viewModel.updateAuthor(author)
                },
                updateBook = { book: Book ->
                    viewModel.updateBook(book)
                },
                navigateBack = navigateBack
            )
        }
    )
}