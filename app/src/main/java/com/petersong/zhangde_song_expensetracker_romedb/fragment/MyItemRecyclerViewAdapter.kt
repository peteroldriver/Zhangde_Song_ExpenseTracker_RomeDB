package com.petersong.zhangde_song_expensetracker_romedb.fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.petersong.zhangde_song_expensetracker_romedb.data.Expense

import com.petersong.zhangde_song_expensetracker_romedb.placeholder.PlaceholderContent.PlaceholderItem
import com.petersong.zhangde_song_expensetracker_romedb.databinding.FragmentItemBinding
class MyItemRecyclerViewAdapter() :
    RecyclerView.Adapter<MyItemRecyclerViewAdapter.ExpenseViewHolder>() {
    private lateinit var expenseList: List<Expense>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(FragmentItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val item = expenseList[position]
        (holder as ExpenseViewHolder).bind(item)
    }

    override fun getItemCount(): Int = expenseList.size

    fun setData(expense: List<Expense>){
        this.expenseList = expense
        notifyDataSetChanged()
    }



    inner class ExpenseViewHolder(
        private val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(e : Expense){
                binding.expenseAmount.text = e.amount.toString()
                //binding.expenseDate.text = e.date.toString()
                binding.expenseNote.text = e.note
                binding.expenseNote.text = e.note
            }
    }

}