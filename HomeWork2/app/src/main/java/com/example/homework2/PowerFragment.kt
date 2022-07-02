package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentPowerBinding

class PowerFragment: Fragment(R.layout.fragment_power) {
    private var _binding: FragmentPowerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPowerBinding.bind(view)
        val text = "Power"

        binding.button.setOnClickListener()
        {
            findNavController().navigate(
                R.id.action_powerFragment_to_gauntletFragment,
                GauntletFragment.createBundle(text),
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
