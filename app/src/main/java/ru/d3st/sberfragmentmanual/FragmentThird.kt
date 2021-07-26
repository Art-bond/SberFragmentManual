package ru.d3st.sberfragmentmanual

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentThird:Fragment(R.layout.fragment_third) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someWord = requireArguments().getString(ENTER_WORD)

        val textField = view.findViewById<TextView>(R.id.tv_output).apply {
            text = someWord
        }

    }
}