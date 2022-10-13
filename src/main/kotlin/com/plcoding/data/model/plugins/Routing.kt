package com.plcoding.data.model.plugins

import com.plcoding.repository.UserRepository
import com.plcoding.repository.UserRepositoryImpl
import com.plcoding.room.RoomController
import com.plcoding.routes.chatSocket
import com.plcoding.routes.getAllMessages
import com.plcoding.routes.loginRoutes
import com.plcoding.routes.userRoutes
import com.plcoding.service.UserServiceImpl
import io.ktor.application.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}

fun Application.configureLogin() {
    val service by inject<UserServiceImpl>()
    val repository: UserRepository = UserRepositoryImpl(service)
    loginRoutes(repository)
}

fun Application.configureAllUser() {
    val service by inject<UserServiceImpl>()
    val repository: UserRepository = UserRepositoryImpl(service)
    userRoutes(repository)
}