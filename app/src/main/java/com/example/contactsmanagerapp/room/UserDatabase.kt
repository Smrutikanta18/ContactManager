package com.example.contactsmanagerapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase :RoomDatabase(){
    abstract val userDAO:UserDAO

    //singleton-only one instances is created
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase?=null
        fun getInstance(context:Context):UserDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "users_db"
                    ).build()
                }
                return instance
            }
        }
    }

}
/* companion object-
Volatile annotation guarantee visibility of changes for other threads as soon as the value is changed
 */