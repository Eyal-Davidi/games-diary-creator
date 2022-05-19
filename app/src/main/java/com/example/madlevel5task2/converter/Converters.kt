package com.example.madlevel5task2.converter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.*

//class Converters {
//    @TypeConverter
//    fun fromTimestamp(value: Long?): LocalDateTime? {
//        return value?.let { LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneOffset.UTC) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: LocalDateTime?): Long? {
//        return date?.atZone(ZoneOffset.UTC)?.toInstant()?.toEpochMilli()
//    }
//}


//class Converters {
//    @TypeConverter
//    fun fromTimestamp(value: Long?): LocalDate? {
//        return value?.let { LocalDate.ofEpochDay(it) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: LocalDate?): Long? {
//        val zoneId: ZoneId = ZoneId.systemDefault()
//        return date?.atStartOfDay(zoneId)?.toEpochSecond()
//    }
//}