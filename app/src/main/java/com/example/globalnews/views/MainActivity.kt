package com.example.globalnews.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globalnews.adapter.RecyclerAdapter
import com.example.globalnews.databinding.ActivityMainBinding

import com.example.globalnews.viewmodel.MyVM


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MyVM

    lateinit var binding: ActivityMainBinding
    private val adapter = RecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyVM::class.java)
        viewModel.down()

        observeLiveData()

        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter



    }

        fun observeLiveData() {
            viewModel.news.observe(this, Observer { news ->
                news?.let {
                    binding.recyclerView.visibility = View.VISIBLE
                    adapter.listeyiGuncelle(news)
                }
            }
            )
            viewModel.eM.observe(this, Observer { eM -> eM?.let { println(eM) } })
        }


}