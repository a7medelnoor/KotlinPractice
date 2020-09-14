package com.a7medelnoor.kotlinPractice.ui.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a7medelnoor.kotlinPractice.data.repository.MainRepository
import com.a7medelnoor.kotlinPractice.model.User
import com.a7medelnoor.kotlinPractice.utils.Resources
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/*
*  Created By: Ahmed Elnoor
*  Date: 9/14/2020
*  Email: ahdnoor4@gmail.com
*  Github: github.com/a7medelnoor
*/
/* ViewModel class for preparing and managing the data for an Activity or a Fragment.
   Also handles the communication of the Activity Fragment with the rest of the application.
   store,manage and prepare UI related data in a lifecycle conscious way
 */
// Impl MainRepository class and extend the class, impl ViewModel constructor invocation
class MainViewModel(private val repository: MainRepository) : ViewModel() {
    // constant of users that hold a list of users in mutableLive data class
    // to notify the ui when onChanged() call, notifying of each time changing data
    private val users = MutableLiveData<Resources<List<User>>>()

    /* RxJava2
     * CompositeDisposable is a convenient class for bundling up multiple Disposables,
     * so that you can dispose them all with one method call on CompositeDisposable.
     */
    private val compositeDisposavle = CompositeDisposable()

    // init block for primary and secondary constructor
    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        // use Rxjava setValue(), postValue()
        // post the value for the three status Success, Loading, Error
        users.postValue(Resources.Loading(null))
        compositeDisposavle.add(
            repository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    users.postValue(Resources.Success(userList))
                }, { throwable ->
                    users.postValue(Resources.Error("somthings went wrong", null))
                }
                )
        )

    }

    // viewModel class function onCleared()
    // clear the viewModel
    override fun onCleared() {
        super.onCleared()
        // destroy the obs/sus
        compositeDisposavle.dispose()
    }
    /*
     *   an observable data holder class, which means it implements the observable design pattern,
     *   which allows us to subscribe entities that will be notified
     *   when the data contained on the LiveData class change.
     *   a class that has only one property, it allows us to save/hold any object into that property.
     */

    fun getUsers(): LiveData<Resources<List<User>>> {
        return users
    }
}