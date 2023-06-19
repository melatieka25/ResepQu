package com.example.resepqu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resepqu.databinding.ActivityMainBinding
import java.util.*
import android.R.menu
import android.annotation.SuppressLint
import android.content.Intent

import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.graphics.toColor


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvRecipe.setHasFixedSize(true)
        list.addAll(getListRecipe())
        showRecyclerList()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)

        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_list -> {
                binding.rvRecipe.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                binding.rvRecipe.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val aboutMeIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(aboutMeIntent)
            }
        }


        return super.onOptionsItemSelected(item)
    }

    private fun getListRecipe(): ArrayList<Recipe> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataAuthorName = resources.getStringArray(R.array.data_author_name)
        val dataAuthorDom = resources.getStringArray(R.array.data_author_dom)
        val dataAuthorPhoto = resources.getStringArray(R.array.data_author_photo)
        val dataCreatedDate = resources.getStringArray(R.array.data_created_date)
        val listRecipe = ArrayList<Recipe>()
        for (i in 0..(dataTitle.size-1)) {
            val listStep = getListStep(i)
            val recipe = Recipe(dataTitle[i], dataDescription[i], dataPhoto[i], dataAuthorName[i], dataAuthorDom[i], dataAuthorPhoto[i], dataCreatedDate[i], listStep)
            listRecipe.add(recipe)
        }
        return listRecipe
    }

    private fun getListStep(position: Int): ArrayList<Step> {
        val listStep = ArrayList<Step>()
        when (position) {
            0 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_0)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_0)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            1 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_1)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_1)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            2 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_2)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_2)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            3 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_3)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_3)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            4 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_4)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_4)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            5 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_5)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_5)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            6 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_6)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_6)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            7 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_7)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_7)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            8 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_8)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_8)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            9 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_9)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_9)

                for (j in 0..(dataStepText.size-1)) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
        }
        return listStep
    }

    private fun showRecyclerList() {
        binding.rvRecipe.layoutManager = LinearLayoutManager(this)
        val listRecipeAdapter = ListRecipeAdapter(list)
        binding.rvRecipe.adapter = listRecipeAdapter

        listRecipeAdapter.setOnItemClickCallback(object  : ListRecipeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Recipe) {
                showSelectedRecipe(data)
            }
        })
    }

    private fun showSelectedRecipe(recipe: Recipe) {

        val moveToDetailResep = Intent(this@MainActivity, DetailResep::class.java)
        moveToDetailResep.putExtra(DetailResep.EXTRA_RECIPE, recipe)
        startActivity(moveToDetailResep)

//        Toast.makeText(this, "Kamu memilih " + recipe.title, Toast.LENGTH_SHORT).show()
    }
}