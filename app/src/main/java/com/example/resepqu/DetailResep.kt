package com.example.resepqu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.resepqu.databinding.ActivityDetailResepBinding
import java.lang.StringBuilder
import java.util.ArrayList

class DetailResep : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailResepBinding
    private var listStep = ArrayList<Step>()
    private lateinit var recipe: Recipe

    companion object {
        const val EXTRA_RECIPE = "extre_recipe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = intent.getParcelableExtra<Recipe>(EXTRA_RECIPE)

        if (recipe != null) {
            binding.tvTitle.text = recipe.title
            binding.tvDetail.text = recipe.description
            Glide.with(this).load(recipe.photo).into(binding.recipeImg)
            Glide.with(this).load(recipe.authorPhoto).into(binding.authorImg)
            binding.tvAuthorName.text = recipe.authorName
            binding.tvAuthorDom.text = recipe.authorDom
            val createdDateInfo = "Resep dibuat pada " + recipe.createdDate
            binding.tvCreatedDate.text = createdDateInfo
            binding.rvStep.setHasFixedSize(true)
            listStep = recipe.listStep
            showRecyclerList()
        }

        binding.btnKembali.setOnClickListener(this)
        binding.btnShare.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val messageShared = StringBuilder()
            if (recipe != null) {
                messageShared.append("Ayo memasak " + recipe.title + "!, berikut langkahnya: ")
                for (item in recipe.listStep) {
                    messageShared.append("\n- " + item.text)
                }
                shareIntent.putExtra(Intent.EXTRA_TEXT, messageShared.toString())
            }
            startActivity(Intent.createChooser(shareIntent, "Share recipe using"))
        }

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.btnKembali.id -> {finish()}
            binding.btnShare.id -> {

            }
        }
    }

    private fun showRecyclerList() {
        binding.rvStep.layoutManager = LinearLayoutManager(this)
        val listStepAdapter = ListStepAdapter(listStep)
        binding.rvStep.adapter = listStepAdapter
    }
}