package com.example.ffff.myfirstapp.api

import com.example.ffff.myfirstapp.model.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ffff on 7/17/17.
 */
interface API {

    @GET("?key=5867364-9959787e0bf9dae47919fa542&q=nature&image_type=photo")
    fun getPhoto():Call<PhotoList>
}