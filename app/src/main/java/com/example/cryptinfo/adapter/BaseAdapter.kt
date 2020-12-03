package com.example.cryptinfo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter <VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>(){

    //список элементов массива
    var items : ArrayList<Any> = ArrayList()

    //Возвращает размер списка
    override fun getItemCount(): Int{
        return items.size
    }
    //Связывает view с содержимым
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
    //возвращает позицию элемента в списке
    fun getItem(position:Int): Any{
        return items[position]
    }
    //функция добаления одного элемента
    fun add(newItem: Any){
        items.add(newItem)
    }
    //функция добавления всех элементов
    fun add(newItems: List<Any>){
        items.addAll(newItems)
    }
    //абстрактный VH
    abstract class BaseViewHolder(protected val view : View) : RecyclerView.ViewHolder(view){
        abstract fun bind(item: Any)
    }
}