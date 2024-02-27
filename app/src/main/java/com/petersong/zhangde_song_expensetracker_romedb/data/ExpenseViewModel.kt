package com.petersong.zhangde_song_expensetracker_romedb.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Appendable

class ExpenseViewModel(application: Application): AndroidViewModel(application) {

    var readAllData : LiveData<List<Expense>>
    private val repository : ExpenseRepository

    init {
        val expenseDao = ExpenseDataBase.getDataBase(application).expenseDao()
        repository = ExpenseRepository(expenseDao)
        readAllData = repository.readAllData
    }

    fun addExpense(e: Expense){
        viewModelScope.launch (Dispatchers.IO){
            repository.addExpense(e)
        }
    }
}