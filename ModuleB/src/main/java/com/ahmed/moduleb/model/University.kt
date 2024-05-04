package com.ahmed.moduleb.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class University(
    val id: Int,
    val alphaTwoCode: String? = "",
    val name: String,
    val country: String,
    val domains: List<String>? = listOf(),
    val webPages: List<String>? = listOf(),
    val stateProvince: String? = ""
) : Parcelable