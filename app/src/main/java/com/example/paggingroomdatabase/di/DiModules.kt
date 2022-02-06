package com.example.paggingroomdatabase.di

import androidx.room.Room
import com.example.paggingroomdatabase.cache.database.AppDatabase
import com.example.paggingroomdatabase.data.NotesRepository
import com.example.paggingroomdatabase.data.NotesRepositoryImpl
import com.example.paggingroomdatabase.ui.list.viewmodel.ListViewModel
import com.example.paggingroomdatabase.ui.main.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { MainViewModel(get()) }
    viewModel { ListViewModel(get()) }
}

val database = module {
    single {  Room.databaseBuilder(androidApplication(), AppDatabase::class.java, AppDatabase.APP_DATABASE).build() }
    factory { get<AppDatabase>().notesDao() }
}

val repositoryModule = module {
    factory<NotesRepository> { NotesRepositoryImpl(get()) }
}

val appModules = listOf(viewModels, database,repositoryModule)