package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentRealityBinding

class RealityFragment : Fragment(R.layout.fragment_reality) {
    private var _binding: FragmentRealityBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRealityBinding.bind(view)
        val text = "Reality"

        binding.button.setOnClickListener()
        {
            findNavController().navigate(
                R.id.action_realityFragment_to_gauntletFragment,
                GauntletFragment.createBundle(text),
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
