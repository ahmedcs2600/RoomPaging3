package com.example.paggingroomdatabase.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paggingroomdatabase.data.NotesRepository
import com.example.paggingroomdatabase.entity.NoteItem
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(private val repository : NotesRepository) : ViewModel() {
    fun insert() {
        viewModelScope.launch {
            val items = (1..100).map { NoteItem(UUID.randomUUID().toString(),"Title$it","Description$it") }
            repository.insert(items)
        }
    }
}