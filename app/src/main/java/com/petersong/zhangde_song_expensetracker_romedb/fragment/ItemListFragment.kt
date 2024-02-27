package com.petersong.zhangde_song_expensetracker_romedb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.petersong.zhangde_song_expensetracker_romedb.R
import com.petersong.zhangde_song_expensetracker_romedb.data.Expense
import com.petersong.zhangde_song_expensetracker_romedb.data.ExpenseViewModel
import com.petersong.zhangde_song_expensetracker_romedb.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class ItemListFragment : Fragment() {
    private var _binding : FragmentItemListBinding? = null
    private val binding get() = _binding!!
    private lateinit var expenseViewModel : ExpenseViewModel
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)


        binding.imageButton.setOnClickListener{
            findNavController().navigate(R.id.action_itemListFragment_to_addFragment3)
        }

        var adapter = MyItemRecyclerViewAdapter()
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = LinearLayoutManager(requireContext())


        expenseViewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)
        expenseViewModel.readAllData.observe(viewLifecycleOwner, Observer { expense ->
            adapter.setData(expense) })
        return binding.root
    }
}