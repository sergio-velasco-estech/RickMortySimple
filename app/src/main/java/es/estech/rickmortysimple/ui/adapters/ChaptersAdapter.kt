package es.estech.rickmortysimple.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import es.estech.rickmortysimple.databinding.HolderChapterBinding

class ChaptersAdapter(val lista: List<String>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ChaptersAdapter.MyHolder>() {

    interface OnItemClickListener {
        fun itemClick(url: String)
    }

    inner class MyHolder(val binding: HolderChapterBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyHolder(HolderChapterBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val url = lista[position]
        val number = url.substringAfterLast("/")
        val title = "Episodio $number"
        holder.binding.tvChapter.text = title

        holder.itemView.setOnClickListener { listener.itemClick(url) }
    }


}