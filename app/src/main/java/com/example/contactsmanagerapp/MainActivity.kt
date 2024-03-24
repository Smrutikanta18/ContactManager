package com.example.contactsmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.contactsmanagerapp.databinding.ActivityMainBinding
import com.example.contactsmanagerapp.room.UserDatabase
import com.example.contactsmanagerapp.room.UserRepository
import com.example.contactsmanagerapp.viewmodel.UserViewModel
import com.example.contactsmanagerapp.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        var button:Button =findViewById(R.id.button)
        val dao=UserDatabase.getInstance(application).userDAO
        val repository=UserRepository(dao)
        val factory=UserViewModelFactory(repository)
        userViewModel=ViewModelProvider(this,
            factory).get(UserViewModel::class.java)
        binding.userViewModel=userViewModel
    }
}