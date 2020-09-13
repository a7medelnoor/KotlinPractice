package com.a7medelnoor.kotlinPractice.api

import com.a7medelnoor.kotlinPractice.model.User
import com.rx2androidnetworking.Rx2ANRequest
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

/*
*  Created By: Ahmed Elnoor
*  Date: 9/13/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/

// ApiServicesImpl a class for implementing the api interface ApiServices and it's function
class ApiServicesImpl : ApiServices {
    // override the getUsers function
    override fun getUsers(): Single<List<User>> {
        // use RxJava2 for android networking
        // get list of users form the specified url
        return Rx2AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
            .build()
            .getObjectListSingle(User::class.java)
    }
}