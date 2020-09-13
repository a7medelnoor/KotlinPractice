package com.a7medelnoor.kotlinPractice.model

import com.google.gson.annotations.SerializedName

/*
*  Created By: Ahmed Elnoor
*  Date: 9/13/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/
// Model data class
data class User(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("avarar")
    val avatar: String = ""

)