package com.petersong.zhangde_song_expensetracker_romedb.data

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromDate(d:Date):Long{
        return d.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }

}