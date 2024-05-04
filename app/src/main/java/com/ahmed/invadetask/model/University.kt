package com.ahmed.invadetask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "universities")
data class University(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val alphaTwoCode: String? = "",
    val name: String,
    val country: String,
    val domains: List<String>? = listOf(),
    val webPages: List<String>? = listOf(),
    @SerializedName("state-province")
    val stateProvince: String? = null

)

