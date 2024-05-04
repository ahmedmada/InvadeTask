package com.ahmed.invadetask.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmed.invadetask.common.Result
import com.ahmed.invadetask.databinding.ActivityUniversityListBinding
import com.ahmed.moduleb.model.University
import com.ahmed.moduleb.ui.UniversityDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UniversityListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversityListBinding
    private val viewModel: UniversityViewModel by viewModels()
    private lateinit var adapter: UniversityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        adapter = UniversityAdapter {

            val university = University(
                it.id,
                it.alphaTwoCode,
                it.name,
                it.country,
                it.domains,
                it.webPages,
                it.stateProvince
            )
            val intent = Intent(this, UniversityDetailsActivity::class.java)
            intent.putExtra("UNIVERSITY", university)
            startActivity(intent)

        }
        binding.universityRecyclerView.adapter = adapter
        binding.universityRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeData() {
        viewModel.result.observe(this) { state ->
            when (state) {
                is Result.Success -> {
                    adapter.submitList(state.universities)
                }

                is Result.Error -> {
                    showError(state.message)
                }
            }
        }

    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
