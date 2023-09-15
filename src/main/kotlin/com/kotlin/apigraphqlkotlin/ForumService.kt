package com.kotlin.apigraphqlkotlin

import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService {
    var itens: MutableMap<String, Post> = HashMap()

    fun create(content: String): Collection<Post?>? {
        val id = UUID.randomUUID().toString()
        val newest = Post(id, content)
        itens[id] = newest
        return itens.values
    }

    fun findById(id: String): Post {
        return itens.getValue(id)
    }
}

@Service
class CommentService {
    var itens: MutableMap<String, Comment> = HashMap()

    fun create(content: String, postId: String): Collection<Comment> {
        val id = UUID.randomUUID().toString()
        val newest = Comment(id, content, postId)
        itens[id] = newest
        return itens.values
    }

    fun findByPost(postId: String): Collection<Comment> {
        return itens.values.stream().filter { comment: Comment ->
            comment.postId == postId
        }.toList()
    }
}