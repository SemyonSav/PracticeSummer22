package com.example.homework2

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.R
import com.example.homework2.databinding.FragmentSpaceBinding

class SpaceFragment : Fragment(R.layout.fragment_space) {
    private var _binding: FragmentSpaceBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSpaceBinding.bind(view)
        val text = "Space"

        binding.button.setOnClickListener()
        {
            findNavController().navigate(
                R.id.action_spaceFragment_to_gauntletFragment,
                GauntletFragment.createBundle(text),
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}