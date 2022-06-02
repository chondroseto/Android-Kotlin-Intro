package com.example.proyek_akhir_android_dicoding.data

import android.R
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyek_akhir_android_dicoding.adapter.ProductAdapter
import com.example.proyek_akhir_android_dicoding.model.Product


class Data {
    private val buyList: MutableList<Product> = ArrayList()

    // Declare preference
    private var preferences: SharedPreferences? = null


    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)
        if (getSupportActionBar() != null) {
            // Enable back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true)
            // Set title
            getSupportActionBar().setTitle("Belanja Produk")
        }
        // Getting preference with mystore name
        preferences = getSharedPreferences("mystore", MODE_PRIVATE)
        // Declare gridView & link with layout grid_view id
        val gridView: GridView = findViewById(R.id.gv)
        // Declare & instantiate products from belanjaJson preference and cast it into List<Product>
        val products: List<Product> = Gson().fromJson(
            preferences!!.getString("belanjaJson", ""),
            object : TypeToken<List<Product?>?>() {}.getType()
        )
        if (products != null) {
            // If product exist, add all data to buyList
            buyList.addAll(products)
        }
        // Declare & Instantiate productList
        val productList: MutableList<Product?> = ArrayList()
        // Add productList static data
        productList.add(
            Product(
                1,
                "https://brain-images-ssl.cdn.dixons.com/7/6/10178467/u_10178467.jpg",
                "TV",
                2500000
            )
        )
        productList.add(
            Product(
                2,
                "https://www.lg.com/au/images/smartphones/md05878255/gallery/V30-medium01.jpg",
                "Smartphone",
                2000000
            )
        )
        productList.add(
            Product(
                3,
                "https://images-na.ssl-images-amazon.com/images/I/71t-J3VJtEL._SX425_.jpg",
                "Laptop",
                1500000
            )
        )
        productList.add(
            Product(
                4,
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ma/imac/215/imac-215-selection-hero-201706_GEO_AU?wid=892&hei=820&&qlt=80&.v=1537286645459",
                "Komputer",
                2250000
            )
        )
        productList.add(
            Product(
                5,
                "https://www.projectorcentral.com/images/projectors2/img10453.jpg",
                "Proyektor",
                1000000
            )
        )
        // Delare & Instantiate adapter with ProductAdapter and give productList as it's data
        val adapter = ProductAdapter(this, productList)
        // Set adapter for gridview
        gridView.adapter = adapter
        // Make gridView columns as 2
        gridView.numColumns = 2
        // Accessing orderOnClick callback
        adapter.orderOnClick(object : OrderCallback() {
            fun orderOnclick(
                id: Int,
                productName: String,
                productPrice: Int,
                productImage: String?
            ) {
                // Instantiate buyList with new data object
                buyList.add(
                    Product(
                        id,
                        productImage!!,
                        productName,
                        productPrice
                    )
                )
                // Convert buyList (Array) as JSON String
                val belanjaJson: String =
                    Gson().toJson(buyList, object : TypeToken<List<Product?>?>() {}.getType())
                // Enable editor for preference
                val editor = preferences!!.edit()
                // Storing data belanjaJson
                editor.putString("belanjaJson", belanjaJson)
                // Applying edit
                editor.apply()
                // Close the activity
                finish()
                Log.d("BelanjaActivity", "pesanOnClick id -> $id")
                Log.d("BelanjaActivity", "belanjaListJson -> $belanjaJson")
                // Show message
                Toast.makeText(this@buy, "$productName berhasil di pesan", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    // Callback given for listening back button
    fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.home) {
            // Go back
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}

class CustomAdapter : RecyclerView.Adapter<Any?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Any {
// infalte the item Layout
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(v)
    }

    fun onBindViewHolder(holder: MyViewHolder?, position: Int) {}
    override fun getItemCount(): Int {
        return 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView // init the item view's
                : TextView

        init {

// get the reference of item view's
            textView = itemView.findViewById(R.id.textView)
        }
    }
}