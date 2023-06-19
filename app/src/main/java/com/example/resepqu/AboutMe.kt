package com.example.resepqu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.resepqu.databinding.ActivityAboutMeBinding
import com.example.resepqu.databinding.ActivityMainBinding
import android.content.Intent
import android.net.Uri


class AboutMe : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKembali.setOnClickListener(this)
        binding.linkedinImg.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.btnKembali.id -> {finish()}
            binding.linkedinImg.id -> {
                val uri: Uri = Uri.parse("https://www.linkedin.com/in/melati-eka-putri/")

                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }
}