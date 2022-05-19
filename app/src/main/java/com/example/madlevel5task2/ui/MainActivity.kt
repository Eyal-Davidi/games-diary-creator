package com.example.madlevel5task2.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.ActivityMainBinding
import com.example.madlevel5task2.viewModel.GameViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: GameViewModel by viewModels()

    //    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toolbar = findViewById(R.id.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment

        navController = navHostFragment.navController


//        val navController = findNavController(R.id.action_AddGameFragment_to_GamesFragment)
        val config = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, config)

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_delete_all -> {
                        deleteAllGames ()
                    true
                }
                else -> false
            }
        }

        binding.plusFab.setOnClickListener { view ->
            navController.navigate(
                R.id.action_GamesFragment_to_AddGameFragment
            )
        }

        fabToggler()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_delete_all -> true

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteAllGames() {
        viewModel.deleteAllGames()
    }

    private fun fabToggler() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.AddGameFragment)) {
                binding.plusFab.hide()
                //xxxxx
//                R.id.action_delete_all.hide()
                //xxxxx
            } else {
                binding.plusFab.show()
            }
        }
    }

//    private fun fabToggler2() {
//        onMenuItemSelected(R.id.action_delete_all) { _, destination, _ ->
//            if (destination.id in arrayOf(R.id.AddGameFragment)) {
//                R.id.action_delete_all
//            } else {
//                binding.plusFab.show()
//            }
//        }
//    }
}