package com.kotlin.apigraphqlkotlin

@JvmRecord
data class Post(val id: String, val content: String)

@JvmRecord
data class Comment(val id: String, val content: String, val postId: String)