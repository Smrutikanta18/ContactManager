package com.example.contactsmanagerapp.room

class UserRepository(private val dao:UserDAO) {
    val users=dao.getallUser()

    suspend fun insert(users:User):Long{
        return dao.insertUser(users)
    }
    suspend fun delete(users: User){
        return dao.deleteUser(users)
    }
    suspend fun update(users: User){
        return dao.updateUser(users)
    }
    suspend fun deleteAll(){
        return dao.delteAll()
     }

}