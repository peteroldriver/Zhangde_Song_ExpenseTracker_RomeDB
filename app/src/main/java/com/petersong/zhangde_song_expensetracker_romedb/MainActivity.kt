package com.petersong.zhangde_song_expensetracker_romedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.petersong.zhangde_song_expensetracker_romedb.data.ExpenseRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ExpenseRepository.initialize(this)
    }
}