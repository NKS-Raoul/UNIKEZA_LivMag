package com.example.livmag.navigation

import com.example.livmag.core.Constants.Companion.BOOKS_SCREEN
import com.example.livmag.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOKS_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
}