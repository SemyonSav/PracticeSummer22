package com.example.homework2

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.homework2.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var adapter: CityAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

//        val text = arguments?.getString(ARG_TEXT).orEmpty()
        initAdapter()
        initPref()
    }

    private fun initAdapter() {
        adapter = CityAdapter(
            CityRepository.cities,
            Glide.with(this)
        ) {
            val id = it.id
            findNavController().navigate(
                R.id.action_spaceFragment_to_cityInfoFragment,
                CityInfoFragment.createBundle(id),
            )
        }
        binding.rvCity.adapter = adapter
        binding.rvCity.layoutManager = GridLayoutManager(requireContext(), 1)

    }

    private fun initPref() {
        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
        val value = pref.getString("PREF_TEXT", "error").orEmpty()
        //binding.root.showSnackbar(value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_TEXT = "amazing"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }

}