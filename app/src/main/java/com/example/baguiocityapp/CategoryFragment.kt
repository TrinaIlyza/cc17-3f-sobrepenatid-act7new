package com.example.baguiocityapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.baguiocityapp.R

class CategoryFragment : Fragment() {

    private val viewModel: RecommendationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)

        val category = arguments?.getString("category") ?: "Coffee Shops"
        view.findViewById<TextView>(R.id.categoryTitle).text = category
        viewModel.loadRecommendations(category)

        val listView = view.findViewById<ListView>(R.id.recommendationListView)
        viewModel.recommendations.observe(viewLifecycleOwner) { recommendations ->
            val adapter = ArrayAdapter(
                requireContext(),
                R.layout.item_place,
                recommendations.map { it.title }
            )
            listView.adapter = adapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val selectedRecommendation = recommendations[position]
                val bundle = Bundle().apply {
                    putString("category", category)  // Pass the current category
                    putString("title", selectedRecommendation.title)
                    putString("description", selectedRecommendation.description)
                    putInt("imageResource", selectedRecommendation.imageResId)
                    putInt("index", position)
                }
                findNavController().navigate(R.id.detailFragment, bundle)
            }

        }
        return view
    }

    private fun navigateToCategory(category: String) {
        val bundle = Bundle().apply { putString("category", category) }
        findNavController().navigate(R.id.categoryFragment, bundle)
    }
}
