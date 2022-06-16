package com.example.proyek_akhir_android_dicoding

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.proyek_akhir_android_dicoding.adapter.ProductAdapter

class HalamanUtama : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var dataRecyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)

        dataRecyclerView = findViewById(R.id.list_rv)
        productAdapter = ProductAdapter()
        dataRecyclerView.adapter = productAdapter


    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        TODO("Not yet implemented")
    }

}