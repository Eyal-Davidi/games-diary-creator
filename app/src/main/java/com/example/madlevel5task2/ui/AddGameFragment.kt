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
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

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

        binding.saveFab.setOnClickListener {
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

        if (gameName.isBlank() or gamePortal.isBlank()) {
            Toast.makeText(
                activity,
                "Please enter a valid game title and portal",
                Toast.LENGTH_LONG
            ).show()
        }

        else {
            try {
                val gameDate = LocalDate.parse(
                    binding.etYear.text.toString() +
                            "-" + binding.etMonth.text + "-" + binding.etDay.text
                )

                viewModel.insertGame(Game(gameName, gamePortal, gameDate))
                findNavController().popBackStack()

            } catch (error: Throwable) {
                Toast.makeText(
                    activity,
                    "Date is not valid. Please enter a valid date",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

