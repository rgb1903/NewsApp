package com.example.globalnews.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.globalnews.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getStringExtra("image")
        val content = intent.getStringExtra("content")
        val title = intent.getStringExtra("title")

        Picasso.get().load(image).into(binding.image)
        binding.title.text = title
        binding.content.text = content


    }
}