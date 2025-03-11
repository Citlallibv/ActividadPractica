package com.example.productosekt.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productosekt.data.ProductEktAPIResponse
import com.example.productosekt.data.Producto
import com.example.productosekt.domain.repository.ProductsEktRepository
import com.example.productosekt.domain.services.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsEktViewModel @Inject constructor(
    private val repository: ProductsEktRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel(){

    private val _productosState = MutableStateFlow<ProductEktAPIResponse<List<Producto>?>>(ProductEktAPIResponse.Loading)
    val productosState: StateFlow<ProductEktAPIResponse<List<Producto>?>> = _productosState.asStateFlow()

    fun loadProducts() {
        viewModelScope.launch(dispatcher) {
            _productosState.value = ProductEktAPIResponse.Loading
            try {
                val productos = repository.getProducts()
                _productosState.value = ProductEktAPIResponse.Success(productos)
            } catch (e: Exception) {
                _productosState.value = ProductEktAPIResponse.Error(e)
            }
        }
    }

}