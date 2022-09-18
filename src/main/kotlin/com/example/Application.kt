package com.example

import com.example.models.Character
import com.example.models.Characters
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.http.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

//fun main() {
//    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
//        configureRouting()
//    }.start(wait = true)
//}

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")

    transaction {
        SchemaUtils.create(Characters)
    }

    transaction {
        Character.new {
            name = "Yukimi Sajo"
            age = "10"
        }
        Character.new {
            name = "Kozue Yusa"
            age = "11"
        }
    }

    configureRouting()
    configureSerialization()
}

