package com.example.baguiocityapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlacesViewModel : ViewModel() {

    private val _coffeeShops = MutableLiveData<List<Place>>().apply {
        value = listOf(
            Place("Cafe by the Ruins", "Historic coffee shop in Baguio", R.drawable.cafe1),
            Place("Arca’s Yard", "Cozy cafe with a view", R.drawable.cafe2),
            Place("Patch Cafe", "Modern cafe with unique coffee blends", R.drawable.cafe3)
        )
    }
    val coffeeShops: LiveData<List<Place>> = _coffeeShops

    private val _thriftShops = MutableLiveData<List<Place>>().apply {
        value = listOf(
            Place("Ukay-Ukay Harrison", "Popular thrift store", R.drawable.ukay1),
            Place("Skyworld", "Affordable second-hand clothes", R.drawable.ukay2),
            Place("Hilltop", "Thrift shop with a variety of options", R.drawable.ukay3)
        )
    }
    val thriftShops: LiveData<List<Place>> = _thriftShops

    private val _famousPlaces = MutableLiveData<List<Place>>().apply {
        value = listOf(
            Place("Burnham Park", "Popular park in Baguio City", R.drawable.place1),
            Place("Mines View Park", "Scenic park with views", R.drawable.place2),
            Place("Botanical Garden", "Garden with diverse flora", R.drawable.place3)
        )
    }
    val famousPlaces: LiveData<List<Place>> = _famousPlaces
}
