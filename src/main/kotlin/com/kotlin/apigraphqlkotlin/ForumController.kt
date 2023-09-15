package com.kotlin.apigraphqlkotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class ForumController {

    @Autowired
    var postService: PostService? = null

    @Autowired
    var commentService: CommentService? = null

    @QueryMapping
    fun postById(@Argument id: String): Post {
        return postService!!.findById(id)
    }

    @MutationMapping
    fun createPost(@Argument content: String): Collection<Post?>? {
        return postService!!.create(content)
    }

    @MutationMapping
    fun createComment(@Argument content: String, @Argument postId: String): Collection<Comment?>? {
        return commentService!!.create(content, postId)
    }

    @SchemaMapping
    fun comments(post: Post): Collection<Comment?>? {
        return commentService!!.findByPost(post.id)
    }
}