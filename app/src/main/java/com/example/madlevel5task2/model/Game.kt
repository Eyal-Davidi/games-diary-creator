package com.example.madlevel5task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameTable")
data class Game(

    @ColumnInfo(name = "gameName")
    var gameName: String,

    @ColumnInfo(name = "gamePortal")
    var gamePortal: String,

    @ColumnInfo(name = "gameDate")
    var gameDate: String, // Date

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

)