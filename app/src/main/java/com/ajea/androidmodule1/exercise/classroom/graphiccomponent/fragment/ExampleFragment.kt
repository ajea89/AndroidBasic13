package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ajea.androidmodule1.R


/**
 * A simple [Fragment] subclass.
 * Use the [ExampleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btSecondFragment = view.findViewById<Button>(R.id.btSecondFragment)
        btSecondFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerCode, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ExampleFragment()
    }
}