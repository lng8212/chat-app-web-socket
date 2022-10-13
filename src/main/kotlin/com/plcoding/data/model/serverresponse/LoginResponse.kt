package com.plcoding.data.model.serverresponse

import io.ktor.http.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer


data class LoginResponse(
    var message: String,
    var status: HttpStatusCode
)
