package com.example.proyek_akhir_android_dicoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.proyek_akhir_android_dicoding.adapter.ProductAdapter
import com.example.proyek_akhir_android_dicoding.model.Product

class HalamanUtama : AppCompatActivity(){

    private lateinit var dataRV: RecyclerView
    private lateinit var dataAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)

        dataRV = findViewById(R.id.list_rv)
        dataAdapter = ProductAdapter(getDataProduct())
        dataRV.adapter = dataAdapter

        //Adapter = ProductAdapter(getDataProduct())

    }

    private fun getDataProduct():MutableList<Product>{

        return mutableListOf(
            Product("Instagram","META","asd","asd","100.000"),
            Product("Instagram","META","asd","asd","100.000")
        )
    }
}