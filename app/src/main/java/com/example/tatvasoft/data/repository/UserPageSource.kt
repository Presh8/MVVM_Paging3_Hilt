package com.example.tatvasoft.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tatvasoft.data.ListUserResponse
import com.example.tatvasoft.data.network.ApiCall
import retrofit2.HttpException
import java.io.IOException

class UserPageSource(private val apiCall: ApiCall) : PagingSource<Int, ListUserResponse.Data.Users>() {

    private val DEFULT_OFFSET = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListUserResponse.Data.Users> {

        val offset = params.key ?: DEFULT_OFFSET

        return try {
            val response = apiCall.getUsers(offset,params.loadSize)
            LoadResult.Page(
                data = response.data?.users,
                prevKey = if (offset == DEFULT_OFFSET) null else offset-1,
                nextKey = if (response.data.users.isEmpty()) null else offset+1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }



    }

    override fun getRefreshKey(state: PagingState<Int, ListUserResponse.Data.Users>): Int? {
       return null
    }
}