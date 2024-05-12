package com.miu.mdp.animalkingdomexplorer.ui.animaldetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.miu.mdp.animalkingdomexplorer.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miu.mdp.animalkingdomexplorer.ui.model.Animal


class AnimalDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = AnimalDetailsFragment()
    }

    private lateinit var viewModel: AnimalDetailsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalAdapter: AnimalAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_animal_details2, container, false)
        recyclerView = view.findViewById(R.id.animal_recycler_view)


        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        animalAdapter = AnimalAdapter(requireContext(),   mutableListOf<Animal>())
        recyclerView.adapter = animalAdapter

        val btnFab = view.findViewById<FloatingActionButton>(R.id.flbAnimal)
        btnFab.setOnClickListener({
            val dialog = AnimalDialogFragment()
            dialog.show(parentFragmentManager,"Add Animal")
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}