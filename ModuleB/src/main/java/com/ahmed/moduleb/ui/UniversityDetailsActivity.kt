package com.ahmed.moduleb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmed.moduleb.databinding.ActivityUniversityDetailsBinding
import com.ahmed.moduleb.model.University

class UniversityDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val university: University? = intent.getParcelableExtra("UNIVERSITY")

        university?.let { displayUniversityDetails(it) }
    }

    private fun displayUniversityDetails(university: University) {
        binding.name.text = university.name
        binding.state.text = university.stateProvince
        binding.country.text = university.country
        if (university.webPages?.isNotEmpty() == true)
            binding.webPage.text = university.webPages[0]
    }
}
