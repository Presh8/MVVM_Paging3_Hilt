/*
package com.example.tatvasoft.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.tatvasoft.databinding.ItemFirstRowBinding
import com.example.tatvasoft.databinding.ItemSecondRowBinding

class AdapterSecond(private val list: MutableList<String>) : RecyclerView.Adapter<AdapterSecond.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemViewModels[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemViewModel: ItemViewModel) {
          //  binding.setVariable(BR.itemViewModel, itemViewModel)
        }
    }
}*/
