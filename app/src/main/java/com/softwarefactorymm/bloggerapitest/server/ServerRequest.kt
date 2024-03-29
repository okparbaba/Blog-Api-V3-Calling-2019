package com.softwarefactorymm.bloggerapitest.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerRequest {
    companion object {
        inline fun <reified T> retrofitCli(): T {
            val ret = Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/blogger/v3/blogs/YOUR_BLOG_ID/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(T::class.java)
            return ret
        }
    }
}