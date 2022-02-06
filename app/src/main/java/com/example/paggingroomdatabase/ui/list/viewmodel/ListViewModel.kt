package com.example.paggingroomdatabase.ui.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.paggingroomdatabase.data.NotesRepository
import com.example.paggingroomdatabase.entity.NoteItem
import kotlinx.coroutines.flow.Flow

class ListViewModel(private val repository: NotesRepository) : ViewModel() {
    val notes: Flow<PagingData<NoteItem>>
        get() = repository.getAll()
}