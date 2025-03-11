package com.example.productosekt.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productosekt.utils.Constants.Companion.TextButton

@Composable
fun ButtonFirstView(onClick: () -> Unit){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(onClick = {onClick.invoke()}) {
            Text(TextButton)
        }
    }
}