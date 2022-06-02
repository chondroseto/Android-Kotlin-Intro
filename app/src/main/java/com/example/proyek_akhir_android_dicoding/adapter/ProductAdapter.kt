package com.example.proyek_akhir_android_dicoding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.proyek_akhir_android_dicoding.R


class ProductAdapter(private val mList: List<ItemViewModel>) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_halaman_utama, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}
/*
class ProductAdapter  // Constructor for ProductAdapter
    (context: Context?, objects: List<Product?>?) :
    ArrayAdapter<Product?>(context, R.layout.item_belanja, objects!!) {
    // Creating orderCallback interface
    private var orderCallback: ProductAdapter.OrderCallback? = null

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        // Create listItem View
        var listItem: View? = convertView
        if (listItem == null) // Inflate listItem with item_belanja layout
            listItem = LayoutInflater.from(context).inflate(R.layout.item_belanja, parent, false)
        // Getting item data for product
        val product = getItem(position)
        // Initialize Views
        val imgProduct: ImageView = listItem.findViewById(R.id.img_produk)
        val tvProductName: TextView = listItem.findViewById(R.id.tv_produk)
        val tvProductPrice: TextView = listItem.findViewById(R.id.tv_harga)
        val btnOrder: Button = listItem.findViewById(R.id.btn_pesan)
        // If product is not empty
        if (product != null) {
            // Set values for Views
            Glide.with(context).load(product.getProductImg()).into(imgProduct)
            tvProductName.setText(product.getProductName())
            tvProductPrice.text = "Rp. " + java.lang.String.valueOf(product.getProductPrice())
            // If this adapter is used for MainActivity
            if (context is MainActivity) {
                // hide btnOrder
                btnOrder.setVisibility(View.GONE)
            }
            // Set onlickListener for btnOrder
            btnOrder.setOnClickListener(object : OnClickListener() {
                fun onClick(v: View?) {
                    if (orderCallback != null) {
                        // Giving the callback
                        orderCallback.orderOnclick(
                            product.getId(),
                            product.getProductName(),
                            product.getProductPrice(),
                            product.getProductImg()
                        )
                    }
                }
            })
        }
        return listItem
    }

    //Make callback
    fun orderOnClick(callback: ProductAdapter.OrderCallback?) {
        orderCallback = callback
    }

    interface OrderCallback {
        fun orderOnclick(id: Int, productName: String?, productPrice: Int, productImage: String?)
    }
}
*/