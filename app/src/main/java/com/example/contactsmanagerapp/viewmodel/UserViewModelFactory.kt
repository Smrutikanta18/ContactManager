package com.example.contactsmanagerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactsmanagerapp.room.UserRepository

class UserViewModelFactory(private val repository: UserRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(UserViewModel::class.java)){
           return UserViewModel(repository) as T
       }
        throw IllegalArgumentException("unknown view model class")
    }
}