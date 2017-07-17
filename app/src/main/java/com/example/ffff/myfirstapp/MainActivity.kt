package com.example.ffff.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.ffff.myfirstapp.api.GetPhotoFromServer
import com.example.ffff.myfirstapp.model.Photo
import com.example.ffff.myfirstapp.model.PhotoList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var photoList:ArrayList<Photo>? = null
    var photoAdapter:PhotoListRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.rvListPhoto.layoutManager = LinearLayoutManager(this)

        val retriever = GetPhotoFromServer()

        val callback = object : Callback<PhotoList> {
            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.d("ResponseError", t.toString())
            }

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photoList = response?.body()!!.hits
                    photoAdapter = PhotoListRecyclerViewAdapter(this@MainActivity, photoList!!)
                    this@MainActivity.rvListPhoto.adapter = photoAdapter
                }

            }

        }
        retriever.getPhotos(callback)
    }
}
