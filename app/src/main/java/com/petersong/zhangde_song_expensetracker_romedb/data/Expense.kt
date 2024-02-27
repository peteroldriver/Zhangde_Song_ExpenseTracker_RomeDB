package com.petersong.zhangde_song_expensetracker_romedb.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity("expense_table")
data class Expense (
    @PrimaryKey(true)
    var id: Int,
    var note: String?,
    //var date : Date,
    var category: String,
    var amount : Float
)
