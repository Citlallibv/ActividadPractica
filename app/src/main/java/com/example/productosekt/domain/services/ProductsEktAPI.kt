package com.example.productosekt.domain.services

import com.example.productosekt.data.ProductsEktData
import com.example.productosekt.utils.Constants.Companion.GET_Request
import retrofit2.http.GET

interface ProductsEktAPI {
    @GET(GET_Request)
    suspend fun obtenerProductos() : ProductsEktData
}