package com.example.anywheremobileexercise

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharactersAdapter(private val charactersList: List<MyCharacter>) :RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.characters_item_details,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return charactersList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${charactersList.size} ")

        return holder.bind(charactersList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var imageView = itemView.findViewById<ImageView>(R.id.ivCharacterImage)
        var tvName = itemView.findViewById<TextView>(R.id.tvCharacterName)
        var tvTitle = itemView.findViewById<TextView>(R.id.tvCharacterTitle)
        var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        fun bind(character: MyCharacter) {

            val name ="Cases :${character.charactername.toString()}"
              tvName.text = character.charactername
              tvTitle.text = character.charactertitle
       //       Picasso.get().load(character.c).into(imageView);
        }

    }
}