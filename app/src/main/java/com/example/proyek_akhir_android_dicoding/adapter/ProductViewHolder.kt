package com.example.proyek_akhir_android_dicoding.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyek_akhir_android_dicoding.R
import com.example.proyek_akhir_android_dicoding.model.Product

class ProductViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {

    private val dataName: TextView = itemView.findViewById(R.id.item_name)


    fun bind(pdct: Product){
        val name = pdct.name

        dataName.text = name

    }

    private fun bindOrHideTextView(textView: TextView, data:String?){
        if (data == null) {
            textView.visibility = View.GONE
        } else {
            textView.text = data
            textView.visibility = View.VISIBLE
        }
    }
}