package com.example.globalnews.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.globalnews.databinding.RecyclerRowBinding
import com.example.globalnews.repos.Article
import com.example.globalnews.views.DetailsActivity
import com.squareup.picasso.Picasso

class RecyclerAdapter(var itemlist : ArrayList<Article>):RecyclerView.Adapter<RecyclerAdapter.NewsVH>() {
    class NewsVH(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsVH(binding)
    }

    override fun getItemCount(): Int {
         return itemlist.size    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val author = itemlist.get(position).author
        val title =  itemlist.get(position).title
        val resim = itemlist.get(position).urlToImage
        val content = itemlist.get(position).content
        val desc = itemlist.get(position).description

        holder.binding.author.text = author
        holder.binding.content.text = content
        holder.binding.title.text = title
        holder.binding.pDate.text = itemlist.get(position).publishedAt
        holder.binding.source.text = itemlist.get(position).source.name
        Picasso.get().load(resim).into(holder.binding.imgView)

        holder.binding.ll.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("title",title)
            intent.putExtra("content",content)
            intent.putExtra("image",resim)
            holder.itemView.context.startActivity(intent)
        }



    }
    fun listeyiGuncelle(newList: List<Article>){
        itemlist.clear()
        itemlist.addAll(newList)
        notifyDataSetChanged()

    }
}
