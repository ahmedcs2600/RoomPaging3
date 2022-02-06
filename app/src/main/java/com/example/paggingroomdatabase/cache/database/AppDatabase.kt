package com.example.paggingroomdatabase.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paggingroomdatabase.cache.dao.NotesDao
import com.example.paggingroomdatabase.entity.NoteItem

@Database(entities = [NoteItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        const val APP_DATABASE = "app_database"
    }
}