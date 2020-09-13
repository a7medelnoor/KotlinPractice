package com.a7medelnoor.kotlinPractice.utils

/*
*  Created By: Ahmed Elnoor
*  Date: 9/13/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/
// data class that only contains the Status class and doesn't preform eny operation
data class Resources<out T>(val status: Status, val data: T?, val message: String?) {

    // a member of a companion object declaration inside the Resources class
    companion object {
        // a function (Success,Loading,Error) that can be called without having a class instance but needs access
        // to the internals of a class
        fun <T> Success(data: T?): Resources<T> {
            return Resources(Status.SUCCESS, data, null)

        }

        fun <T> Error(message: String, data: T?): Resources<T> {
            return Resources(Status.ERROR, data, message)
        }

        fun <T> Loading(data: T?): Resources<T> {
            return Resources(Status.LOADING, data, null)
        }
    }
}