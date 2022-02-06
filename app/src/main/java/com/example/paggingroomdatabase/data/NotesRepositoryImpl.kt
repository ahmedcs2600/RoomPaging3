package com.example.paggingroomdatabase.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.paggingroomdatabase.cache.dao.NotesDao
import com.example.paggingroomdatabase.cache.database.AppDatabase
import com.example.paggingroomdatabase.entity.NoteItem
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(private val mNotesDao: NotesDao) : NotesRepository {

    companion object {
        const val PAGE_SIZE = 10
    }

    override fun getAll(): Flow<PagingData<NoteItem>> {
        return Pager(PagingConfig(PAGE_SIZE)) {
            mNotesDao.getAll()
        }.flow
    }


    override suspend fun insert(item: List<NoteItem>) {
        mNotesDao.insert(item)
    }
}