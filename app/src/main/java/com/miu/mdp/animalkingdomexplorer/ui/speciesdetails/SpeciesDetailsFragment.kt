package com.miu.mdp.animalkingdomexplorer.ui.speciesdetails;

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miu.mdp.animalkingdomexplorer.R
import com.miu.mdp.animalkingdomexplorer.ui.model.Specie
import com.miu.mdp.animalkingdomexplorer.ui.speciesdetails.SpecieDialogFragment
import com.miu.mdp.animalkingdomexplorer.ui.speciesdetails.SpeciesDetailsViewModel
import com.miu.mdp.speciekingdomexplorer.ui.speciesdetails.SpecieAdapter

class SpeciesDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = SpeciesDetailsFragment()
    }

    private lateinit var viewModel: SpeciesDetailsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var specieAdapter: SpecieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_species_details2, container, false)
        recyclerView = view.findViewById(R.id.specie_recycler_view)


        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        specieAdapter = SpecieAdapter(requireContext(),   mutableListOf<Specie>())
        recyclerView.adapter = specieAdapter

        val btnFab = view.findViewById<FloatingActionButton>(R.id.flbSpecie)
        btnFab.setOnClickListener({
            val dialog = SpecieDialogFragment()
            dialog.show(parentFragmentManager,"Add Specie")
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeciesDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}