package com.example.tatvasoft.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tatvasoft.ListUserResponse
import com.example.tatvasoft.data.repository.UserPageSource
import com.example.tatvasoft.data.network.ApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.Flow
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val Apicall : ApiCall) : ViewModel() {

    val getAllUser : Flow<PagingData<ListUserResponse>> = Pager(
        config = PagingConfig(10,enablePlaceholders = false)){
        UserPageSource(Apicall)
    }.flow.cachedIn(viewModelScope)

}