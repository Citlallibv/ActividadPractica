package com.example.productosekt.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun ProductEktCard(productName: String, productPrice: Double, productCategory: String, productImage: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { }
    ) {
        val painterCard = rememberAsyncImagePainter(model = productImage)
        Image(
            painter = painterCard,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Text(productName, modifier = Modifier.padding(horizontal = 5.dp))
        Text("$productPrice", modifier = Modifier.padding(horizontal = 5.dp))
        Text(productCategory, modifier = Modifier.padding(horizontal = 5.dp))

    }
}

@Preview
@Composable
fun PreviewCard() {
    ProductEktCard(productName = "Motocicleta", productPrice = 1200.00, productCategory = "Vehiculos", productImage = "")
}