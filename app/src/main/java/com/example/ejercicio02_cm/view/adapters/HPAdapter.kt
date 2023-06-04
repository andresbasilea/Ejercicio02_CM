package com.example.ejercicio02_cm.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio02_cm.databinding.HpelementBinding
import com.example.ejercicio02_cm.model.CharacterDetails

class HPAdapter(private var context: Context, private var characters: ArrayList<CharacterDetails>): RecyclerView.Adapter<HPAdapter.ViewHolder>() {

    class ViewHolder(view: HpelementBinding): RecyclerView.ViewHolder(view.root){
        val ivImage = view.ivImage
        val tvNombrePersonaje = view.tvNombrePersonaje
        val tvActor = view.tvActor
        val tvDateOfBirth = view.tvDateOfBirth
        val tvHouse = view.tvHouse


    }

    //

    interface OnItemClickListener{
        fun onItemClick(character: CharacterDetails)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }









    //






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HpelementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombrePersonaje.text = characters[position].name
        holder.tvActor.text = characters[position].actor
        holder.tvDateOfBirth.text = characters[position].dateOfBirth
        holder.tvHouse.text = characters[position].house

        Glide.with(context)
            .load(characters[position].image)
            .into(holder.ivImage)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(characters[position])
        }
    }


}