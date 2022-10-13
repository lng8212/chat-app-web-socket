package com.plcoding.service

import com.plcoding.data.model.LoginParams
import com.plcoding.data.model.User
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq
import kotlin.math.log

class UserServiceImpl(
    private val db: CoroutineDatabase
) : UserService {
    override suspend fun checkLogin(user: LoginParams): Boolean {
        val tbUser = db.getCollection<User>("tbUser")
        val u: User? = tbUser.findOne(User::phoneNum eq user.phoneNum)
        return u != null && u.password == user.password
    }

    override suspend fun getAllUser(): List<User> {
        println("(------: ${db.listCollectionNames()})")
        val tbUser = db.getCollection<User>("tbUser")
//        val result = mu
        return tbUser.find().toList()
    }
}