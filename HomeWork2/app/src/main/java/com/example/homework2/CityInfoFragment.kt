package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework2.databinding.FragmentCityinfoBinding
import com.example.homework2.databinding.FragmentMindBinding
import com.google.android.material.snackbar.Snackbar

class CityInfoFragment : Fragment(R.layout.fragment_cityinfo) {
    private var _binding: FragmentCityinfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCityinfoBinding.bind(view)

        val id = arguments?.getInt("ID")

        if (id != null) {
            val obj = CityRepository.cities[id]

            binding.textCountry.setText("Country: ${obj.country}")
            binding.textID.setText("ID: $id")
            binding.textName.setText("Name: ${obj.name}")
            Glide.with(this)
                .load(obj.url)
                .into(binding.imageView)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {

        private const val ARG_TEXT = "ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(
                ARG_TEXT,
                id
            )
            return bundle
        }
    }
}