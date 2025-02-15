package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.fragment.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidmodule1.R
import com.ajea.androidmodule1.databinding.FragmentSendParamsBinding
import com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview.AnimalEntity


class SendParamsFragment : Fragment() {

    private lateinit var binding : FragmentSendParamsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSendParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.btSendParams.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.paramsContainer, ReceiveParamsFragment.newInstance("Leon", AnimalEntity("Perro", "café", ""), true))
                .addToBackStack("ReceiveParamsFragment")
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}