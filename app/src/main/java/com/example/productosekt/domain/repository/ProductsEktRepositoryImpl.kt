package com.example.productosekt.domain.repository

import com.example.productosekt.data.Producto
import com.example.productosekt.domain.services.ProductsEktAPI
import com.example.productosekt.domain.services.di.IoDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

class ProductsEktRepositoryImpl @Inject constructor(
    private val api: ProductsEktAPI,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ProductsEktRepository{

    override suspend fun getProducts() : List<Producto>? {
        val response = api.obtenerProductos()
        return if (response.resultado.productos.isNotEmpty()){
            response.resultado.productos
        } else {
            null
        }
    }
}