package com.plcoding.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginParams(
    var phoneNum: String,
    var password: String
)
