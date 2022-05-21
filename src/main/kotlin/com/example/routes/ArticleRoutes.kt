package com.example.routes

import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.articleRouting() {
    route("/api/article") {
        get {
            if (articleStorage.isNotEmpty()) {
                call.respond(articleStorage)
            } else {
                call.respondText("No article found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val article = articleStorage.find { it.id == id } ?: return@get call.respondText(
                "No article with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(article)
        }

        post {
            val article = call.receive<Article>()
            articleStorage.add(article)
            call.respondText("Article stored correctly", status = HttpStatusCode.Created)
        }

        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (articleStorage.removeIf { it.id == id }) {
                call.respondText("Article removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}