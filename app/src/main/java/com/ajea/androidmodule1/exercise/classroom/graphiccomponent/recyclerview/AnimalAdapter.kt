package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidmodule1.R
import com.squareup.picasso.Picasso

class AnimalAdapter(val list: List<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var onItemSelected : ((AnimalEntity) -> Unit)? = null

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvColor = view.findViewById<TextView>(R.id.tvColor)
        val card = view.findViewById<CardView>(R.id.cardAnimal)
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)

        fun render(animalEntity: AnimalEntity, onItemSelected : ((AnimalEntity) -> Unit)?){
            tvName.text = animalEntity.name
            tvColor.text = animalEntity.color

            card.setOnClickListener {
                onItemSelected?.invoke(animalEntity)
            }

            Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_android)
                .into(ivAnimal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }
}