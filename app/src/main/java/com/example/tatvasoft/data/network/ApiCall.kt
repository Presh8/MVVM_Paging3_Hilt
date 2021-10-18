package com.example.tatvasoft.data.network

import com.example.tatvasoft.data.ListUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {


    companion object{

        const val  BASE_URL = "http://sd2-hiring.herokuapp.com"
        //http://sd2-hiring.herokuapp.com/api/users?offset=0&limit=10
    }

    @GET("api/users")
    fun getUsers(
        @Query("offset") offset : Int,
        @Query("limit") limit : Int,
    ) : List<ListUserResponse>
}