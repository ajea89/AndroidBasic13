package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidmodule1.R
import com.ajea.androidmodule1.databinding.ItemAnimalBinding
import com.squareup.picasso.Picasso

class AnimalAdapter(val list: List<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var onItemSelected : ((AnimalEntity) -> Unit)? = null

    class AnimalViewHolder(val binding : ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root){

        fun render(animalEntity: AnimalEntity, onItemSelected : ((AnimalEntity) -> Unit)?){
            binding.tvName.text = animalEntity.name
            binding.tvColor.text = animalEntity.color

            binding.cardAnimal.setOnClickListener {
                onItemSelected?.invoke(animalEntity)
            }

            Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_android)
                .into(binding.ivAnimal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }
}