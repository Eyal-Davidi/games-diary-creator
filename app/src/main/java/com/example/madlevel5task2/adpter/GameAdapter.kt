package com.example.madlevel5task2.adpter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.ItemGameBinding
import com.example.madlevel5task2.model.Game
import java.time.format.DateTimeFormatter

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemGameBinding.bind(itemView)


        fun databind(game: Game) {
            binding.tvGameTitle.text = game.gameTitle
            binding.tvGamePlatform.text = game.gamePortal
//            binding.tvGameDate.text = game.gameDate // CHANGE TO DATE
//            val formatter = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy")
//            binding.tvGameDate.text = formatter.format(game.gameDate)
        }
    }
    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }
    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size
    }
    /**
     * Called by RecyclerView to display the data at the specified position.
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }
}