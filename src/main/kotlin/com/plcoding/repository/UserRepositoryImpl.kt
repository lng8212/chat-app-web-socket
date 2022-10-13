package com.plcoding.repository

import com.plcoding.data.model.LoginParams
import com.plcoding.data.model.User
import com.plcoding.service.UserService

class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {
    override suspend fun login(user: LoginParams): Boolean {
        return userService.checkLogin(user)
    }

    override suspend fun getAllUser(): List<User> {
        return userService.getAllUser()
    }
}