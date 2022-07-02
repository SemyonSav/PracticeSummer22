package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentMindBinding

class MindFragment: Fragment(R.layout.fragment_mind) {
    private var _binding: FragmentMindBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMindBinding.bind(view)
        val text = "Mind"

        binding.button.setOnClickListener()
        {
            findNavController().navigate(
                R.id.action_mindFragment_to_gauntletFragment,
                GauntletFragment.createBundle(text),
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}