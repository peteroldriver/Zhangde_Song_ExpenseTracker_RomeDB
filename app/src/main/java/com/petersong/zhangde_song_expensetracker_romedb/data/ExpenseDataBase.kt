package com.petersong.zhangde_song_expensetracker_romedb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDataBase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object{
        @Volatile
        private var INSTANCE : ExpenseDataBase? =null

        fun getDataBase(context: Context): ExpenseDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDataBase::class.java,
                    "expense_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}