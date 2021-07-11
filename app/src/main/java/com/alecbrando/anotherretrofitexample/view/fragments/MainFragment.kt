package com.alecbrando.anotherretrofitexample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alecbrando.anotherretrofitexample.R
import com.alecbrando.anotherretrofitexample.databinding.FragmentMainBinding
import com.alecbrando.anotherretrofitexample.repository.Repository
import com.alecbrando.anotherretrofitexample.view.adapters.CatViewAdapter
import com.alecbrando.anotherretrofitexample.viewmodel.MainViewModel
import com.alecbrando.anotherretrofitexample.viewmodel.MainViewModelFactory


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    private var _binding : FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.run {
//
//        }
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCats(20)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.response.observe(viewLifecycleOwner, Observer { response ->
            binding.recyclerView.adapter =  CatViewAdapter(response.body()!!)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}