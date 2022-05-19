package com.example.madlevel5task2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.FragmentAddGameBinding
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.viewModel.GameViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private var _binding: FragmentAddGameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        HIDE THE ACTION BAR
//        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

//        (R.id.action_delete_all as AppCompatActivity).supportActionBar?.hide()


        binding.saveFab.setOnClickListener {
//            findNavController().navigate(R.id.action_AddGameFragment_to_GamesFragment)
            onAddGame()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onAddGame() {
        val gameName = binding.etTitle.text.toString()
        val gamePortal = binding.etPlatform.text.toString()
        val gameDate = binding.etDay.text.toString()

        //GAME DAY + GAME MONTH + GAME YEAR IN MODEL

        ////GAMEPORTAL + GAMEDATE
        if (gameName.isNotBlank() and gamePortal.isNotBlank()) {
            viewModel.insertGame(Game(gameName, gamePortal, gameDate))
            findNavController().popBackStack()

        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_game, Toast.LENGTH_SHORT
            ).show()
        }
    }
}