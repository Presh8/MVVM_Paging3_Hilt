package com.example.tatvasoft.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tatvasoft.data.ListUserResponse
import com.example.tatvasoft.databinding.ItemFirstRowBinding
import javax.inject.Inject

class UserAdapter @Inject constructor() : PagingDataAdapter<ListUserResponse,UserAdapter.UserViewHolder>(diff()) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val userItem = getItem(position)?.data?.users?.get(position)

        if (userItem!=null){
            holder.bind(userItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
     return UserViewHolder(ItemFirstRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    class  UserViewHolder(private val binding: ItemFirstRowBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(userItem: ListUserResponse.Data.Users) {
            binding.apply {
                imgUser.load(userItem.image)
                tvUserName.text = userItem.name
            }
        }

    }


    class diff : DiffUtil.ItemCallback<ListUserResponse>() {
        override fun areItemsTheSame(
            oldItem: ListUserResponse,
            newItem: ListUserResponse
        ): Boolean = oldItem.data == newItem.data

        override fun areContentsTheSame(
            oldItem: ListUserResponse,
            newItem: ListUserResponse
        ): Boolean = oldItem == newItem


    }

}