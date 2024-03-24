package com.example.contactsmanagerapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    val id:Int,
    @ColumnInfo(name="user_name")
    val name:String,
    @ColumnInfo(name="user_eamil")
    val email:String
)


//Creation of Room database
//The above code the Entity Class creation means table creation