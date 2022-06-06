package com.example.madlevel5task2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import com.example.madlevel5task2.adpter.GameAdapter
import com.example.madlevel5task2.databinding.FragmentGamesBinding
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.viewModel.GameViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class GamesFragment : Fragment() {

    private var _binding: FragmentGamesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeAddGameResult()
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        binding.rvGames.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvGames.adapter = gameAdapter
        createItemTouchHelper().attachToRecyclerView(binding.rvGames)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Create a touch helper to recognize when a user swipes an item from a recycler view.
     * An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
     * and uses callbacks to signal when a user is performing these actions.
     */
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val gameToDelete = games[position]
                viewModel.deleteGame(gameToDelete)
            }
        }
        return ItemTouchHelper(callback)
    }
    private fun observeAddGameResult() {
        viewModel.games.observe(viewLifecycleOwner, { games ->
            this@GamesFragment.games.clear()
            this@GamesFragment.games.addAll(games)
            gameAdapter.notifyDataSetChanged()
        })
    }
}