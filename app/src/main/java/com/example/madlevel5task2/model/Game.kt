package com.example.madlevel5task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "gameTable")
data class Game(

    @ColumnInfo(name = "gameName")
    var gameTitle: String,

    @ColumnInfo(name = "gamePortal")
    var gamePortal: String,

//    @ColumnInfo(name = "gameDate")
//    var gameDate: LocalDate,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

)