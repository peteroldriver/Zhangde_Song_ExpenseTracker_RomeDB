package com.petersong.zhangde_song_expensetracker_romedb.data

import androidx.lifecycle.LiveData

class ExpenseRepository (private val expenseDao: ExpenseDao){

    val readAllData: LiveData<List<Expense>> = expenseDao.readAllData()

    suspend fun addExpense(expense: Expense){
        expenseDao.addExpense(expense)
    }
}