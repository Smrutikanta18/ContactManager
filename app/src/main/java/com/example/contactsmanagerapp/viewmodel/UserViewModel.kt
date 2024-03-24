package com.example.contactsmanagerapp.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsmanagerapp.room.User
import com.example.contactsmanagerapp.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository):ViewModel(),Observable {
    val users=repository.users
    private var isUpdateOrDelete=false
    private lateinit var userToUpdateOrDelte:User
    @Bindable
    val Inputname=MutableLiveData<String?>()
    @Bindable
    val Inputemail=MutableLiveData<String?>()
    @Bindable
    val saveOrUpadetButton=MutableLiveData<String>()
    @Bindable
    val clearOrDelteButton=MutableLiveData<String>()

    init {
        saveOrUpadetButton.value="Save"
        clearOrDelteButton.value="Clear All"
    }
    fun save(){
        val name=Inputname.value!!
        val email=Inputemail.value!!

        insert(User(0,name,email))
        Inputemail.value=null
        Inputname.value=null

    }
    fun clearAllorDelete(){
        clearAll()
    }

    fun insert(user: User)=viewModelScope.launch {
        repository.insert(user)
    }

    fun clearAll()=viewModelScope.launch {
        repository.deleteAll()

    }
    fun update(user: User)=viewModelScope.launch {
        repository.update(user)
    }
    fun delete(user: User)=viewModelScope.launch {
        repository.delete(user)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}