package com.example.tatvasoft.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tatvasoft.ListUserResponse
import com.example.tatvasoft.data.network.ApiCall
import retrofit2.HttpException
import java.io.IOException

class UserPageSource(private val apiCall: ApiCall) : PagingSource<Int,ListUserResponse>() {

    private val DEFULT_OFFSET = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListUserResponse> {

        val offset = params.key ?: DEFULT_OFFSET

        return try {
            val response = apiCall.getUsers(offset,params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (offset == DEFULT_OFFSET) null else offset-1,
                nextKey = if (response.isEmpty()) null else offset+1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }



    }

    override fun getRefreshKey(state: PagingState<Int, ListUserResponse>): Int? {
       return null
    }
}