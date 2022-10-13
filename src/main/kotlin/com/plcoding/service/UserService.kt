package com.plcoding.service

import com.plcoding.data.model.LoginParams
import com.plcoding.data.model.User

interface UserService {
    suspend fun checkLogin(user: LoginParams): Boolean

    suspend fun getAllUser() : List<User>
}