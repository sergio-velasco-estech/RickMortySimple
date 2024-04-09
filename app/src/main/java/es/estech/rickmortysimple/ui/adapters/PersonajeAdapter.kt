package es.estech.rickmortysimple.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.estech.rickmortysimple.R
import es.estech.rickmortysimple.data.modelos.Personaje
import es.estech.rickmortysimple.databinding.VistaCeldaBinding


/**
 * Created by sergi on 05/04/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class PersonajeAdapter(val personajes: List<Personaje>, val listener: MyClick) :
    RecyclerView.Adapter<PersonajeAdapter.MiCelda>() {

        interface MyClick {
            fun onClick(personaje: Personaje)
        }

    inner class MiCelda(val binding: VistaCeldaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaCeldaBinding.inflate(layoutInflater, parent, false)
        return MiCelda(binding)
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val personaje: Personaje = personajes.get(position)
        holder.binding.tvName.text = personaje.name

        Glide.with(holder.itemView).load(personaje.image).into(holder.binding.ivImage)

        holder.itemView.setOnClickListener {
           listener.onClick(personaje)
        }

        when (personaje.status) {
            "Alive" -> holder.binding.ivCirculo.setImageResource(R.drawable.circle_green)
            "Dead" -> holder.binding.ivCirculo.setImageResource(R.drawable.circle_red)
            else -> holder.binding.ivCirculo.setImageResource(R.drawable.circle_yellow)
        }
    }

    override fun getItemCount(): Int {
        return personajes.size
    }
}