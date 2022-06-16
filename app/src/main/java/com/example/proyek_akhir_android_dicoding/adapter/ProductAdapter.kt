package com.example.proyek_akhir_android_dicoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyek_akhir_android_dicoding.R
import com.example.proyek_akhir_android_dicoding.model.Product

class ProductAdapter(val product: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        TODO("Not yet implemented")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
        val pdct = product[position]

        val dtName = holder.itemView.findViewById<TextView>(R.id.item_name)

        dtName.text = pdct.name

        //holder.itemView.findViewById<TextView>(R.id.item_name) = pdct.name
        //holder.itemView.findViewById<TextView>(R.id.item_name) = pdct.name
        //holder.itemView.findViewById()


        //holder.itemView.txtSocialMedia.text = social.name
        //holder.itemView.txtFoundingYear.text = social.foundingYear.toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "${pdct.name} is the best social media in the world.",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.itemView.setOnLongClickListener {
            remove(pdct)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return product.size
    }

    fun add(item: Product) {
        val positon = product.indexOf(item)
        product.removeAt(positon)
        notifyItemRemoved(positon)
    }

    fun remove(item:Product) {
        val position = product.indexOf(item)
        product.removeAt(position)
        notifyItemRemoved(position)
    }

    class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        //val dtName = itemView.findViewById<TextView>(R.id.item_name)

    }

}