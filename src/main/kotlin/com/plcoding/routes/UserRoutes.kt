package com.plcoding.routes

import com.plcoding.data.model.LoginParams
import com.plcoding.repository.UserRepository
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.userRoutes(repository: UserRepository) {
    routing {
        route("/users") {
            get("/user") {
                val x = repository.getAllUser()
                call.respond(x)
            }
        }
    }
}

