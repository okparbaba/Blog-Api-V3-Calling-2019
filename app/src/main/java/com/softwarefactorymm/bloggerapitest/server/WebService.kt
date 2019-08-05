package com.softwarefactorymm.bloggerapitest.server

import com.softwarefactorymm.bloggerapitest.Posts
import retrofit2.Call
import retrofit2.http.*

interface WebService {
    @GET("posts")
    fun getAllPost(@Query("key") k:String):Call<Posts>

}