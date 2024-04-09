package es.estech.rickmortysimple.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import es.estech.rickmortysimple.ui.MainActivity
import es.estech.rickmortysimple.ui.MyViewModel
import es.estech.rickmortysimple.databinding.PersonajeFragmentBinding
import es.estech.rickmortysimple.ui.adapters.ChaptersAdapter


/**
 * Created by sergi on 05/04/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class FragmentPersonaje : Fragment() {

    private lateinit var binding: PersonajeFragmentBinding
    private val viewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PersonajeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPersonaje().observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name
            binding.tvName.text = it.name
            Glide.with(this).load(it.image).into(binding.ivImage)

            binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerview.adapter =
                ChaptersAdapter(it.episode, object : ChaptersAdapter.OnItemClickListener {
                    override fun itemClick(url: String) {

                    }
                })

            binding.tvStatus.text = it.status
            binding.tvSpecies.text = it.species
            binding.tvOrigin.text = it.origin.name
            binding.tvLocation.text = it.location.name
            binding.tvGender.text = it.gender

            binding.butOri.isVisible = !it.origin.url.isEmpty()
            binding.butLoc.isVisible = !(it.location.url.isEmpty())
        }
    }
}