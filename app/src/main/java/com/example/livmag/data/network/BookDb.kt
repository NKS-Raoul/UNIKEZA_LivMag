package com.example.livmag.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livmag.domain.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDb : RoomDatabase() {
    abstract fun bookDao(): BookDao
}