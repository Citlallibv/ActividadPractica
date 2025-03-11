package com.example.productosekt.data

sealed class ProductEktAPIResponse<out T> {
    object Loading : ProductEktAPIResponse<Nothing>()
    data class Success<T>(val data: T) : ProductEktAPIResponse<T>()
    data class Error(val exception: Exception) : ProductEktAPIResponse<Nothing>()
}