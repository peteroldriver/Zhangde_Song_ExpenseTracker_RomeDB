package com.petersong.zhangde_song_expensetracker_romedb.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExpense(e: Expense)

    @Query("SELECT * FROM expense_table ORDER BY date DESC")
    fun readAllData(): LiveData<List<Expense>>
}