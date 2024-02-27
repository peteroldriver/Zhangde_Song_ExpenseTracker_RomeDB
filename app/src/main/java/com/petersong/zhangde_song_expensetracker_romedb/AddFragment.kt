package com.petersong.zhangde_song_expensetracker_romedb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.petersong.zhangde_song_expensetracker_romedb.data.Expense
import com.petersong.zhangde_song_expensetracker_romedb.data.ExpenseViewModel
import com.petersong.zhangde_song_expensetracker_romedb.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private var _binding : FragmentAddBinding? = null
    private val binding get() = _binding!!
    lateinit var expenseViewModel: ExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root

        expenseViewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)

        binding.buttonAdd.setOnClickListener {
            insertDatatoDataBase()
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.expense_category,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            binding.spinnerCategory.adapter = adapter
        }


        return view
    }

    private fun insertDatatoDataBase() {
        var id = 0
        var note = binding.editTextNote.text.toString()
        var date = binding.editTextDate.text
        var category = binding.spinnerCategory.selectedItem.toString()
        var amount = binding.editTextAmount.text.toString().toFloat()

            var e = Expense(id,note, category, amount)
            expenseViewModel.addExpense(e)
            Toast.makeText(requireContext(), "Add Success!",Toast.LENGTH_SHORT).show()

    }

}
