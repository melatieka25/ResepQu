package com.example.resepqu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resepqu.databinding.ItemRowRecipeBinding
import java.util.*

class ListRecipeAdapter(private val listRecipe: ArrayList<Recipe>) : RecyclerView.Adapter<ListRecipeAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Recipe)
    }

    class ListViewHolder (var binding: ItemRowRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, photo, authorName, authorDom, authorPhoto, createdDate, listStep) = listRecipe[position]
        Glide.with(holder.itemView.context).load(photo).into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = title
        val numOfStep = " " + listStep.size.toString() + " Langkah"
        holder.binding.tvItemDescription.text = numOfStep
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listRecipe[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listRecipe.size
}