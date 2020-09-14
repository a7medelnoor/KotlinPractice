package com.a7medelnoor.kotlinPractice.ui.main.base

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a7medelnoor.kotlinPractice.data.api.ApiHelper
import com.a7medelnoor.kotlinPractice.data.repository.MainRepository
import com.a7medelnoor.kotlinPractice.ui.main.viewModel.MainViewModel

// factory of the viewModel class which extend and Impl the apiHelper, MainViewModel class
class ViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // check if model class is assignable or not from the MainViewModel class
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            // and return the apiHelper indside the MainRepository that MAinViewModel class contain as a T parameter
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        // else exception message
        throw IllegalArgumentException("Unknown class name")
    }
}