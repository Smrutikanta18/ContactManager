package com.example.contactsmanagerapp.room

import androidx.core.text.util.LocalePreferences.FirstDayOfWeek.Days
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User):Long
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("delete from user")
    suspend fun delteAll()
    @Query("select * from user")
    fun getallUser():LiveData<List<User>>
}
//Data Access Object
//Where we define functions that access the database
/* suspend is a keyword in kotlin used for executing a long running operation
and wait for it to complete it.
basically function that we can pause and resume later(perform asyncronous operation)
 */