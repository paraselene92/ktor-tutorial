package com.example.plugins

import com.example.models.Character
import com.example.routes.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/path") {
            call.respondText("Hello World !!")
        }
        get("/idol") {
            val character = transaction {
                Character.all().sortedBy {
                    it.name
                }
            }
            call.respondText(character.joinToString {
                it.name
            })
        }
    }
    routing {
        customerRouting()
        listOrdersRoute()
        getOrderRoute()
        totalizeOrderRoute()
    }
}
