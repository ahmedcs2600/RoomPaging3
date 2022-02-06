package com.example.paggingroomdatabase.cache.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paggingroomdatabase.entity.NoteItem

@Dao
interface NotesDao {
    @Insert
    suspend fun insert(item: NoteItem)

    @Insert
    suspend fun insert(item: List<NoteItem>)

    @Query("SELECT * FROM tbl_notes")
    fun getAll(): PagingSource<Int, NoteItem>
}