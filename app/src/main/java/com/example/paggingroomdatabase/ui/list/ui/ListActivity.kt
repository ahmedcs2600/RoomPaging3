package com.example.paggingroomdatabase.ui.list.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paggingroomdatabase.databinding.ActivityListBinding
import com.example.paggingroomdatabase.ui.list.viewmodel.ListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    private lateinit var mAdapter: PagingAdapter

    private val mViewModel by viewModel<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpAdapter()
        bindViewModel()
    }

    private fun bindViewModel() {
        lifecycleScope.launch {
           mViewModel.notes.collectLatest {
               mAdapter.submitData(it)
           }
        }
    }

    private fun setUpAdapter() {
        val adapter = PagingAdapter().also { mAdapter = it }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                super.onItemRangeChanged(positionStart, itemCount)
                Log.e("onItemRangeChanged","$itemCount")
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                Log.e("onItemRangeInserted","$itemCount")
            }
        })
    }
}