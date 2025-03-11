package com.example.productosekt.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productosekt.data.Producto

@Composable
fun ListProducts(
    listProduct: List<Producto>?,
    listener: (ProductsEktListOption) -> Unit,
) {
    val listProductsEkt = remember { listProduct }
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        listProductsEkt?.let { productos ->
            items(productos.size) { index ->
                ProductEktCard(
                    productName = productos[index].nombre,
                    productPrice = productos[index].precioFinal,
                    productCategory = productos[index].codigoCategoria,
                    productImage = productos[index].urlImagenes.first()
                )
            }
        }
    }
}