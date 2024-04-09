package es.estech.rickmortysimple.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import es.estech.rickmortysimple.R
import es.estech.rickmortysimple.data.modelos.Personaje
import es.estech.rickmortysimple.databinding.ListaFragmentBinding
import es.estech.rickmortysimple.ui.MyViewModel
import es.estech.rickmortysimple.ui.adapters.PersonajeAdapter


/**
 * Created by sergi on 05/04/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class FragmentLista : Fragment() {

    private lateinit var binding: ListaFragmentBinding
    private val viewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListaFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadData()

        viewModel.getData().observe(viewLifecycleOwner) {
            configRecycler(it)
        }


    }

    private fun configRecycler(listaPersonajes: List<Personaje>) {
        val recyclerView = binding.recyclerview
        val adapter = PersonajeAdapter(listaPersonajes, object : PersonajeAdapter.MyClick{
            override fun onClick(personaje: Personaje) {
                viewModel.setPersonaje(personaje)
                findNavController().navigate(R.id.action_fragmentLista_to_fragmentPersonaje)
            }

        })
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}