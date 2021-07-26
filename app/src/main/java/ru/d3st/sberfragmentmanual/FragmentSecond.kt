package ru.d3st.sberfragmentmanual

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentSecond : Fragment() {

    private var btnEnter: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*btnEnter = getView()?.findViewById<Button>(R.id.btn_enter)?.apply {
            setOnClickListener {
                showTextInThirdFragment()
            }
        }*/

    }

    private fun showTextInThirdFragment() {
    }
}