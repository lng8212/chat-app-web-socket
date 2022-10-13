package com.plcoding.repository

import com.plcoding.data.model.LoginParams
import com.plcoding.data.model.User

interface UserRepository {
    suspend fun login(user: LoginParams): Boolean
    suspend fun getAllUser() : List<User>
}