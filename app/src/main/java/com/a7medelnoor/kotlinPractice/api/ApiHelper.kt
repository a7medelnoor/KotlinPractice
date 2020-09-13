package com.a7medelnoor.kotlinPractice.api

import com.a7medelnoor.kotlinPractice.model.User
import io.reactivex.Single

/*
*  Created By: Ahmed Elnoor
*  Date: 9/13/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/
// A helper class that impl the interface class ApiServices anf get it's member function
class ApiHelper(private val apiServices: ApiServices) {
    fun getUsers() = apiServices.getUsers()

}