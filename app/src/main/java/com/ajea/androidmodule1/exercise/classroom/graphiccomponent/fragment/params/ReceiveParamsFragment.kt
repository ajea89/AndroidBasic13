package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.fragment.params

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidmodule1.R
import com.ajea.androidmodule1.databinding.FragmentReceiveParamsBinding
import com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview.AnimalEntity


class ReceiveParamsFragment : Fragment() {

    private lateinit var binding : FragmentReceiveParamsBinding

    private var name : String? = ""
    private var animal : AnimalEntity? = null

    private var isFromLogin : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString("EXTRA_NAME")
            animal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                it.getSerializable("EXTRA_ANIMAL", AnimalEntity::class.java)
            }else{
                it.getSerializable("EXTRA_ANIMAL") as AnimalEntity
            }
            isFromLogin = it.getBoolean("EXTRA_IS_FROM_LOGIN")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceiveParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Toast.makeText(requireContext(), "name: $name animalName: ${animal?.name} animalColor: ${animal?.color}", Toast.LENGTH_LONG).show()

        binding.btOpenActivity.setOnClickListener {
                val intent = Intent(requireContext(), SecondParamsActivity::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                    putExtra("EXTRA_ANIMAL", animal)
                }
                startActivity(intent)
        }



        if (isFromLogin){
            binding.btOpenActivity.text = "Login"
        }else{
            binding.btOpenActivity.text = "Home"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance(name :String, animal : AnimalEntity, isFromLogin :Boolean) = ReceiveParamsFragment().apply {
            arguments = Bundle().apply {
                putString("EXTRA_NAME", name)
                putSerializable("EXTRA_ANIMAL", animal)
            }
        }
    }
}