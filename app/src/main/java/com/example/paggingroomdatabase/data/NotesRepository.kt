package com.example.paggingroomdatabase.data

import androidx.paging.PagingData
import com.example.paggingroomdatabase.entity.NoteItem
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    fun getAll(): Flow<PagingData<NoteItem>>

    suspend fun insert(item: List<NoteItem>)
}