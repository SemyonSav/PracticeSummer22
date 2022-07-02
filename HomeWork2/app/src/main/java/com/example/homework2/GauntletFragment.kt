package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class GauntletFragment: Fragment(R.layout.fragment_gauntlet) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = arguments?.getString("TEXT").orEmpty()

        if (text.isNotEmpty())
        {
            Snackbar.make(view, "Teleport from $text", Snackbar.LENGTH_LONG).show()
        }
    }

    companion object {

        private const val ARG_TEXT = "TEXT"

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