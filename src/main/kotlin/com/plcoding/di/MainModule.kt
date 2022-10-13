package com.plcoding.di

import com.mongodb.ConnectionString
import com.plcoding.data.MessageDataSource
import com.plcoding.data.MessageDataSourceImpl
import com.plcoding.room.RoomController
import com.plcoding.service.UserServiceImpl
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient(ConnectionString("mongodb+srv://dungtran:dungtranmongodb2301@cluster0.w2wrzs5.mongodb.net/?retryWrites=true&w=majority"))
            .coroutine
            .getDatabase("appchat")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }

    single {
        UserServiceImpl(get())
    }
}