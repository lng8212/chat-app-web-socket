package com.plcoding.routes

import com.google.gson.Gson
import com.plcoding.data.model.LoginParams
import com.plcoding.data.model.serverresponse.LoginResponse
import com.plcoding.repository.UserRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.loginRoutes(repository: UserRepository) {
    routing {
        route("/auth") {
            post("/login") {
                val params = call.receive<LoginParams>()
                val result = repository.login(params)
                val gson = Gson()
                if (result) {
                    call.respond(HttpStatusCode.OK, gson.toJson(LoginResponse("Login successfully!", HttpStatusCode.OK)))
                }
                else {
                    call.respond(HttpStatusCode.Unauthorized, gson.toJson(LoginResponse("Login fail!", HttpStatusCode.Unauthorized)))
                }
            }
        }
    }
}

