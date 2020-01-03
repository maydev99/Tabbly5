package com.bombadu.tabbly5

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bombadu.tabbly5.model.NewsData
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.jar.Manifest

class TabTwo : Fragment() {


    private var listData = mutableListOf<NewsData>()
    private var isTextColor = false

    //private var client: OkHttpClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tab2, container, false)
        val twoTextView = view.findViewById<TextView>(R.id.twoTextView)



        twoTextView.setOnClickListener {
            isTextColor = if (!isTextColor) {
                twoTextView.setTextColor(Color.GREEN)
                true
            } else {
                twoTextView.setTextColor(Color.BLACK)
                false
            }
        }

        getTheData()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onStart() {
        super.onStart()
        //getTheData() * Removed to RecView returns to the same location after leaving and returning to the app
    }

    private fun getTheData() {
        var newsApiKey = BuildConfig.NEWS_API_KEY
        var title = ""
        var description = ""
        var imageUrls = ""
        var webUrl = ""
        var author = ""


        var client = OkHttpClient()
        val url = "https://newsapi.org/v1/articles?source=engadget&apiKey=$newsApiKey"
        val request = Request.Builder().url(url).build()
        val call = client.newCall(request)
        call?.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("RESPONSE FAILED")
            }

            override fun onResponse(call: Call, response: Response) {
                val myResponse = response.body!!.string()

                println("RESPONSE: $myResponse")

                try {
                    val jsonObject = JSONObject(myResponse)
                    val articlesJA = jsonObject.getJSONArray("articles")
                    for (i in 0 until articlesJA.length()) {
                        val jsonIndex = articlesJA.getJSONObject(i)
                        title = jsonIndex.getString("title")
                        description = jsonIndex.getString("description")
                        imageUrls = jsonIndex.getString("urlToImage")
                        webUrl = jsonIndex.getString("url")
                        author = jsonIndex.getString("author")
                        if (author == "null") {
                            author = "by Anonymous"
                        } else {
                            author = "by $author"
                        }

                        println(title)

                        listData.add(NewsData(title, description, imageUrls, author, webUrl))


                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                if (response.isSuccessful) {
                    activity?.runOnUiThread {
                        println("true")

                        val recyclerView: RecyclerView = view!!.findViewById(R.id.recyclerView)
                        recyclerView.layoutManager = LinearLayoutManager(context)
                        val newsAdapter = NewsAdapter(listData)
                        recyclerView.adapter = newsAdapter


                    }
                }


            }
        })


    }




}









