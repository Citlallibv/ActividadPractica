package com.example.productosekt.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.productosekt.data.ProductEktAPIResponse
import com.example.productosekt.data.Producto
import com.example.productosekt.viewmodel.ProductsEktViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyScreenOne(
    viewModel: ProductsEktViewModel = hiltViewModel(),
    listener: (ProductsEktListOption) -> Unit
) {
    var isPressed = remember { mutableStateOf(false) }
    val productosState = viewModel.productosState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        ButtonFirstView(onClick = {isPressed.value = true})
        if (isPressed.value == true) {
            viewModel.loadProducts()
        }
        when (val state = productosState.value) {
            is ProductEktAPIResponse.Loading -> if (isPressed.value) LoadingScreen()
            is ProductEktAPIResponse.Success -> {
                isPressed.value = false
                state.data?.let {
                    if (it.isNotEmpty()){
                        ListProducts(listProduct = it, listener = listener)
                    }
                }

            }
            is ProductEktAPIResponse.Error -> ErrorScreen(exception = state.exception)
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(exception: Exception) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Error: ${exception.localizedMessage}")
    }
}

sealed interface ProductsEktListOption {
    object Loader : ProductsEktListOption
}