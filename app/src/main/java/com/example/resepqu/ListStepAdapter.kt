package com.example.resepqu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resepqu.databinding.ItemRowStepBinding
import java.util.*

class ListStepAdapter(private val listStep: ArrayList<Step>) : RecyclerView.Adapter<ListStepAdapter.ListViewHolder>(){

    class ListViewHolder (var binding: ItemRowStepBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (text, photo) = listStep[position]
        Glide.with(holder.itemView.context).load(photo).into(holder.binding.imgItemPhoto)
        val stepPosition = "Langkah " + (position+1)
        holder.binding.tvItemName.text = stepPosition
        holder.binding.tvItemDescription.text = text
    }

    override fun getItemCount(): Int = listStep.size
}