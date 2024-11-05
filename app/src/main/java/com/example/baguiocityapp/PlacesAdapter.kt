package com.example.baguiocityapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PlacesAdapter : RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>() {

    private var places = emptyList<Place>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.name.text = place.name
        holder.description.text = place.description
        holder.imageView.setImageResource(place.imageResId) // Directly set image
    }

    override fun getItemCount(): Int = places.size

    fun submitList(list: List<Place>) {
        places = list
        notifyDataSetChanged()
    }

    inner class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.placeName)
        val description: TextView = itemView.findViewById(R.id.placeDescription)
        val imageView: ImageView = itemView.findViewById(R.id.placeImage) // Updated layout required
    }
}

