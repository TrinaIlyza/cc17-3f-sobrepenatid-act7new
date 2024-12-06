package com.example.baguiocityapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecommendationViewModel : ViewModel() {

    private val _recommendations = MutableLiveData<List<Recommendation>>()
    val recommendations: LiveData<List<Recommendation>> = _recommendations
    fun loadRecommendations(category: String) {
        val sampleData = when (category) {
            "Coffee Shops" -> listOf(
                Recommendation(
                    "Cafe by the Ruins",
                    "Historic coffee shop in Baguio.",
                    R.drawable.cafe1),
                Recommendation(
                    "Arca’s Yard",
                    "Cozy cafe with a view",
                    R.drawable.cafe2),
                Recommendation(
                    "Patch Cafe",
                    "Modern cafe with unique coffee blends",
                    R.drawable.cafe3),
            )
            "Famous Places" -> listOf(
                Recommendation(
                    "Burnham Park",
                    "Popular park in Baguio City",
                    R.drawable.place1),
                Recommendation(
                    "Mines View Park",
                    "Scenic park with views",
                    R.drawable.place2),
                Recommendation(
                    "Botanical Garden",
                    "Garden with diverse flora",
                    R.drawable.place3),
            )
            "Thrift Shops" -> listOf(
                Recommendation(
                    "Ukay-Ukay Harrison",
                    "Popular thrift store.",
                    R.drawable.ukay1),
                Recommendation(
                    "Skyworld",
                    "Affordable second-hand clothes",
                    R.drawable.ukay2),
                Recommendation(
                    "Hilltop",
                    "Thrift shop with a variety of options",
                R.drawable.ukay3),
            )
            else -> emptyList()
        }
        _recommendations.value = sampleData
    }
}