package com.a7medelnoor.kotlinPractice.data.repository

import com.a7medelnoor.kotlinPractice.data.api.ApiHelper
import com.a7medelnoor.kotlinPractice.model.User
import io.reactivex.Single

/*
*  Created By: Ahmed Elnoor
*  Date: 9/13/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/

//The repository class provides a clean API for data access to the rest of the app.
// Impl ApiHelper class
class MainRepository(private val apiHelper: ApiHelper) {
    // return single element of the user in a list
    // asign the value into a function named getUsers
    fun getUsers(): Single<List<User>> {
        // then return the apiHelper member function
        return apiHelper.getUsers()
    }
}