package com.a7medelnoor.kotlinPractice.data.api

import com.a7medelnoor.kotlinPractice.model.User
import io.reactivex.Single

/*
*  Created By: Ahmed Elnoor
*  Date: 9/13/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/
// API class for calling API Server
interface ApiServices {
    // return a single element of user in a list using Rxjava
    fun getUsers(): Single<List<User>>
}