package com.example.resepqu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Step(
    val text : String,
    val photo: String
) : Parcelable
