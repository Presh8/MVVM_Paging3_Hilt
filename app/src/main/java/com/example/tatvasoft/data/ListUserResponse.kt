package com.example.tatvasoft.data

import com.squareup.moshi.Json

data class ListUserResponse(
    @Json(name = "data")
    val data: Data
){
    data class Data(
        @Json(name = "has_more")
        val has_more : Boolean,
        @Json(name = "users")
        val users : List<Users>
    ){
        data class Users(
            @Json(name = "name")
            val name : String,
            @Json(name = "image")
            val image : String,
            @Json(name = "items")
            val item : MutableList<String>
        )
    }
}
