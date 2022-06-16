package com.example.proyek_akhir_android_dicoding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyek_akhir_android_dicoding.R
import com.example.proyek_akhir_android_dicoding.model.Product

class ProductAdapter() : RecyclerView.Adapter<ProductViewHolder>() {

    private val TAG = javaClass.simpleName
    private var AllData: Array<Product>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        TODO("Not yet implemented")
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.bind(AllData!![position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return if (AllData == null) 0 else AllData!!.size
    }

    fun setAllData(data:Array<Product>?){
        AllData = data
        notifyDataSetChanged()
    }
}