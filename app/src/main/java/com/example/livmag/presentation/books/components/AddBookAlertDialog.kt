package com.example.livmag.presentation.books.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.job
import com.example.livmag.core.Constants.Companion.ADD
import com.example.livmag.core.Constants.Companion.ADD_BOOK
import com.example.livmag.core.Constants.Companion.AUTHOR
import com.example.livmag.core.Constants.Companion.BOOK_TITLE
import com.example.livmag.core.Constants.Companion.DISMISS
import com.example.livmag.core.Constants.Companion.NO_VALUE
import com.example.livmag.domain.model.Book

@Composable
fun AddBookAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addBook: (book: Book) -> Unit
) {
    if (openDialog) {
        var title by remember { mutableStateOf(NO_VALUE) }
        var author by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = ADD_BOOK
                )
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = BOOK_TITLE
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = author,
                        onValueChange = { author = it },
                        placeholder = {
                            Text(
                                text = AUTHOR
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val book = Book(0, title, author)
                        addBook(book)
                    }
                ) {
                    Text(
                        text = ADD
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = DISMISS
                    )
                }
            }
        )
    }
}