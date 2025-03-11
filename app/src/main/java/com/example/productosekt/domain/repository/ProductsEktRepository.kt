package com.example.productosekt.domain.repository

import com.example.productosekt.data.Producto

interface ProductsEktRepository {

    suspend fun getProducts() : List<Producto>?
}