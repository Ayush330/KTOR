package com.example

import com.example.data.LoginRequest
import com.example.data.LoginResponse
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = true)
{

    install(ContentNegotiation){
        gson {  }
    }


    routing {
        get("/"){
            call.respondText("Hello Ayush")
        }

        get("/test"){
            call.respondText("This is a get Route")
        }

        post("/login"){
            val dataReceived = call.receive<LoginRequest>()
            val Username = dataReceived.username
            val Password = dataReceived.password

            if(Username=="Ayush" && Password=="6205906795")
            {
                call.respond(LoginResponse("true","You are logged in."))
            }
            else
            {
                call.respond(LoginResponse("false","Invalid credentials"))
            }
        }
    }
}

