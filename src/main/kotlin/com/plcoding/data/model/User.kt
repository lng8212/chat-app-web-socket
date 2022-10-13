package com.plcoding.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.codecs.pojo.annotations.BsonRepresentation
import org.bson.types.ObjectId

@Serializable
data class User(
    @BsonId
    var id: String = ObjectId().toString(),
    var userName: String?,
    var phoneNum: String?,
    var password: String?
)
