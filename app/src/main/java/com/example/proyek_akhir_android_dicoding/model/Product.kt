package com.example.proyek_akhir_android_dicoding.model

class Product {

    var name:String
    var merk:String
    var releaseDate:String
    var spec:String
    var price:String

    constructor(name: String, merk: String, releaseDate: String, spec: String, price: String) {
        this.name = name
        this.merk = merk
        this.releaseDate = releaseDate
        this.spec = spec
        this.price = price
    }
}