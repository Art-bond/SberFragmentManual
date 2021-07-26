package ru.d3st.sberfragmentmanual

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.*

private const val FRAGMENT_TAG = "FRAGMENT_TAG"
const val ENTER_WORD = "ENTER_WORD"


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var mThirdContainer: ViewGroup? = null
    private var textFrom: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentFirst>(R.id.fragment_container_first)
                add<FragmentSecond>(R.id.fragment_container_second)
            }
        } else{
            textFrom = savedInstanceState.getString(ENTER_WORD)

            if (textFrom != null) {
                createThirdFragment(savedInstanceState)
            }
        }



    }

    override fun onResume() {
        super.onResume()
        val fragmentOne: FragmentFirst =
            supportFragmentManager.findFragmentById(R.id.fragment_container_first) as FragmentFirst
        val fragmentTwo: FragmentSecond =
            supportFragmentManager.findFragmentById(R.id.fragment_container_second) as FragmentSecond


        fragmentTwo.requireView().findViewById<Button>(R.id.btn_enter)?.apply {
            setOnClickListener {
                textFrom = fragmentOne.requireView()
                    .findViewById<EditText>(R.id.et_enter_word).text.toString()

                val bundle = bundleOf(ENTER_WORD to textFrom)
                createThirdFragment(bundle)


                Log.i(FRAGMENT_TAG, "text $textFrom")
            }
        }

    }


    private fun createThirdFragment(bundle: Bundle) {
        val root = findViewById<LinearLayout>(R.id.root_view)
        if (mThirdContainer == null) {
            mThirdContainer = FragmentContainerView(this)
            mThirdContainer?.id = View.generateViewId()
            mThirdContainer?.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
            root.addView(mThirdContainer)
        }
        var thirdFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)
        if (thirdFragment == null) {
            thirdFragment = Fragment()
        }
        supportFragmentManager.commit {
            replace<FragmentThird>(mThirdContainer!!.id, FRAGMENT_TAG, args = bundle)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putAll(bundleOf(ENTER_WORD to textFrom))
        Log.i(FRAGMENT_TAG, "data saved $textFrom")
    }


}