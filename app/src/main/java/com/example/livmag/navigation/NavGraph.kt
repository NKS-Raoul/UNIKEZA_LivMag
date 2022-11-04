package com.example.livmag.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.example.livmag.core.Constants.Companion.BOOK_ID
import com.example.livmag.navigation.Screen.BooksScreen
import com.example.livmag.navigation.Screen.UpdateBookScreen
import com.example.livmag.presentation.books.BooksScreen
import com.example.livmag.presentation.update_book.UpdateBookScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BooksScreen.route
    ) {
        composable(
            route = BooksScreen.route
        ) {
            BooksScreen(
                navigateToUpdateBookScreen = { bookId ->
                    navController.navigate("${UpdateBookScreen.route}/${bookId}")
                }
            )
        }
        composable(
            route = "${UpdateBookScreen.route}/{$BOOK_ID}",
            arguments = listOf(
                navArgument(BOOK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(
                bookId = bookId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}