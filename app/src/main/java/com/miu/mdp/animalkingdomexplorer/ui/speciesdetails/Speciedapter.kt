package com.miu.mdp.speciekingdomexplorer.ui.speciesdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.animalkingdomexplorer.R
import com.miu.mdp.animalkingdomexplorer.ui.model.Specie

class SpecieAdapter(private val context: Context, private val species: List<Specie>) :
    RecyclerView.Adapter<SpecieAdapter.SpecieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_specie_layout, parent, false)
        return SpecieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecieViewHolder, position: Int) {
        val specie = species[position]
        holder.bind(specie)
    }

    override fun getItemCount(): Int {
        return species.size
    }

    inner class SpecieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val specieNameTextView: TextView = itemView.findViewById(R.id.text_specie_name)
        private val specieDescriptionTextView: TextView = itemView.findViewById(R.id.text_specie_description)

        fun bind(specie: Specie
        ) {
            specieNameTextView.text = specie.name
            specieDescriptionTextView.text =  specie.description
        }
    }
}