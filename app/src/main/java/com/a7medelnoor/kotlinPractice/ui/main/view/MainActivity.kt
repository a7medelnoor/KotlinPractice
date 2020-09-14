package com.a7medelnoor.kotlinPractice.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.a7medelnoor.kotlinPractice.R
import com.a7medelnoor.kotlinPractice.data.api.ApiHelper
import com.a7medelnoor.kotlinPractice.data.api.ApiServicesImpl
import com.a7medelnoor.kotlinPractice.model.User
import com.a7medelnoor.kotlinPractice.ui.main.adapter.MainAdapter
import com.a7medelnoor.kotlinPractice.ui.main.base.ViewModelFactory
import com.a7medelnoor.kotlinPractice.ui.main.viewModel.MainViewModel
import com.a7medelnoor.kotlinPractice.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

/*
*  Created By: Ahmed Elnoor
*  Date: 9/14/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/

// our MainActivity UI
class MainActivity : AppCompatActivity() {
    // init viewModel
    private lateinit var mainViewModel: MainViewModel

    // init mainAdapter
    private lateinit var mainAdapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setup the UI
        setupUI()
        // setupViewModel
        setupViewModel()
        // setup the Observer -- Rxjava --
        setupObserver()
    }

    private fun setupObserver() {
        // setup the observer function that observe the data
        // use the viewModel function to observe from this context to the observer
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    // when Success
                    progressBar.visibility = View.GONE
                    // get list of users
                    it.data?.let { users -> renderUsersList(users) }
                    // set it in recycler view
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    // when loading
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    // handel  error
                    progressBar.visibility = View.GONE
                   Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private fun renderUsersList(users: List<User>) {
        // add users to the addData() function which it's add all users in a list
        mainAdapter.addData(users)
        // notify the ui when there is a change in data
        mainAdapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        // setup the main view model class and set the view model factory
        // ApiHelper class and the ApiServiceImpl the data layer and the API call
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServicesImpl()))
        )
            .get(MainViewModel::class.java)
    }

    private fun setupUI() {
        // setup the recyclear view item
        recyclerView.layoutManager = LinearLayoutManager(this)
        mainAdapter = MainAdapter(arrayListOf())
        // recycler view item
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        // set the adapter
        recyclerView.adapter = mainAdapter
    }
}