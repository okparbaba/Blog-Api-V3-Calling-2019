package com.softwarefactorymm.bloggerapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.softwarefactorymm.bloggerapitest.server.ServerRequest.Companion.retrofitCli
import com.softwarefactorymm.bloggerapitest.server.WebService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofitCli<WebService>()
            .getAllPost("YOUR_API_KEY-k")
            .enqueue(object :Callback<Posts>{
                override fun onFailure(call: Call<Posts>, t: Throwable) {

                }
                override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                    if (response.isSuccessful){
                        val postsList = response.body()?.items
                        if (postsList != null) {
                            val pattern = Pattern.compile("\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))")
                            for (i in postsList){
                                val o = i.content

                                val r = pattern.matcher(o)
                               while(r.find()){
                                   val result = r.group(1)
                                   val re = result.replace("\"","")
                                   Log.e("compile",re)
                               }

                            }
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                            recyclerView.adapter = PostAdapter(this@MainActivity,postsList)
                        }
                    }
                }

            })


    }

}
