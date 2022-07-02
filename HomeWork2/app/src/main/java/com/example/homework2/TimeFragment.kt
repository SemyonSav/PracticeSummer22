package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentTimeBinding

class TimeFragment: Fragment(R.layout.fragment_time) {
    private var _binding: FragmentTimeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTimeBinding.bind(view)
        val text = "Time"

        binding.button.setOnClickListener()
        {
            findNavController().navigate(
                R.id.action_timeFragment_to_gauntletFragment,
                GauntletFragment.createBundle(text),
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}