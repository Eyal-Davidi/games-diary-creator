package com.example.madlevel5task2.converter

import androidx.room.TypeConverter
import java.time.LocalDate

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

class Converters {
    @TypeConverter
    fun toDate(dateString: String?): LocalDate? {
        return if (dateString == null) {
            null
        } else {
            LocalDate.parse(dateString)
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDate?): String? {
        return if (date == null) {
            null
        } else {
            date.toString()
        }
    }
}
