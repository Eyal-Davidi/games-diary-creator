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
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
//        val gameDate= LocalDate.now().format(formatter)
        val gameDate= "Release: " + (LocalDate.parse(binding.etYear.text.toString() +
                "-" + binding.etMonth.text + "-" + binding.etDay.text)).format(formatter)

//        val fullDate = LocalDate.parse((binding.etDay.text.toString() +
//                "-" + binding.etMonth.text + "-" + binding.etYear.text).format(formatter))

//        val fullDate = binding.etDay.text.toString() +
//                "-" + binding.etMonth.text + "-" + binding.etYear.text
//        val fullDate = ("21-12-2022")
//        val date2 = formatter.format(fullDate)
//        val gameDate = LocalDate.parse(date2)

//        val formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy")
//        binding.tvGameDateHistory.text = formatter.format(game.gameDate)
//        val gameDate = LocalDate.parse(binding.etYear.text.toString()
//                + "-" + binding.etMonth.text + "-" + binding.etDay.text)


//        qvar formattedDate = binding.etDay.text.toString().format(formatter)
//
//        val gameDate = LocalDate.parse(formattedDate)

//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
//        val gameDate = LocalDate.parse(binding.etDay.text).format(formatter)

//        assertThat(binding.etDay.text).isEqualTo("2018-12-31")

//        val gameDateDetails = binding.etDay.text.toString() + binding.etMonth.text.toString() + binding.etYear.text.toString()

//        val gameDateDetails = binding.etDay.text
//        val gameDate= OffsetDateTime.parse(gameDateDetails).toLocalDate()
//        val gameDate : LocalDate = binding.etDay.toString()
//        static fun parse(gameDate: LocalDate): LocalDate!


//        val formatter = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy")
//        var da = formatter.format(game.gameDate)
//        val gameDate = LocalDateTime.now()


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

