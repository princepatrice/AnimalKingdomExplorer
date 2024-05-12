package com.miu.mdp.animalkingdomexplorer.ui.animaldetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.animalkingdomexplorer.R
import com.miu.mdp.animalkingdomexplorer.ui.model.Animal

class AnimalAdapter(private val context: Context, private val animals: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal_layout, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.bind(animal)
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val animalNameTextView: TextView = itemView.findViewById(R.id.text_animal_name)
        private val animalHabitatTextView: TextView = itemView.findViewById(R.id.text_animal_habitat)
        private val animalDietTextView: TextView = itemView.findViewById(R.id.text_animal_diet)

        fun bind(animal: Animal
        ) {
            animalNameTextView.text = animal.name
            animalDietTextView.text =  animal.diet
            animalHabitatTextView.text = animal.habitat

        }
    }
}