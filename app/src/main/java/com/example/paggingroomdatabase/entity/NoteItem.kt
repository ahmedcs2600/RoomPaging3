package com.example.paggingroomdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_notes")
data class NoteItem(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : String,

    @ColumnInfo(name = "name")
    val name : String,

    @ColumnInfo(name = "description")
    val description : String,
)
