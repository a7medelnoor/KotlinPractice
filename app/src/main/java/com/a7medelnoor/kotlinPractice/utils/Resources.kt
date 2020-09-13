package com.a7medelnoor.kotlinPractice.utils

data class Resources<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {

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