package com.example.ffff.myfirstapp.api

import com.example.ffff.myfirstapp.model.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ffff on 7/17/17.
 */
class GetPhotoFromServer {

    private val service : API

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(API::class.java)
    }

    fun getPhotos(callback: Callback<PhotoList>){
        val call = service.getPhoto()
        call.enqueue(callback)
    }
}