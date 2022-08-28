package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.http.*

//fun main() {
//    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
//        configureRouting()
//    }.start(wait = true)
//}

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureRouting()
    configureSerialization()
}

