package com.example.tatvasoft.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tatvasoft.R
import com.example.tatvasoft.adapter.UserAdapter
import com.example.tatvasoft.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainUserViewModel : UserViewModel by viewModels()

    @Inject
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMainRecyclerView()


        lifecycleScope.launchWhenStarted {
            mainUserViewModel.getAllUser.collectLatest { userData ->
                binding.apply {
                    progressBar.isVisible = false
                    rvMain.isVisible = true
                }
                userAdapter.submitData(userData)
            }
        }



    }

   private fun setMainRecyclerView(){
       binding.apply {

           rvMain.apply {
               layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,true)
               adapter = userAdapter
           }
       }
   }
}