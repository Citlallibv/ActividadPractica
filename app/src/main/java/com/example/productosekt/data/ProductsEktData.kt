package com.example.productosekt.data

data class ProductsEktData(
    val advertencia: String,
    val mensaje: String,
    val resultado: Resultado
)

data class Resultado(
    val categoria: String,
    val paginacion: Paginacion,
    val productos: List<Producto>
)

data class Producto(
    val abonosSemanales: List<AbonosSemanale>,
    val codigoCategoria: String,
    val descuento: Boolean,
    val disponibleCredito: Boolean,
    val id: String,
    val idLinea: Int,
    val idModalidad: Int,
    val lineaCredito: String,
    val montoDescuento: Double,
    val nombre: String,
    val pagoSemanalPrincipal: Int,
    val plazoPrincipal: Int,
    val porcentajeDescuento: Double,
    val precioCredito: Double,
    val precioFinal: Double,
    val precioRegular: Int,
    val relevancia: Int,
    val sku: String,
    val urlImagenes: List<String>
)

data class AbonosSemanale(
    val idPromocion: Int,
    val montoAbono: Int,
    val montoAbonoDigital: Int,
    val montoDescuentoAbono: Int,
    val montoDescuentoBanco: Int,
    val montoDescuentoElektra: Int,
    val montoFinalCredito: Int,
    val montoUltimoAbono: Int,
    val plazo: Int,
    val precio: Int
)

data class Paginacion(
    val pagina: Int,
    val totalPaginas: Int,
    val totalRegistros: Int,
    val totalRegistrosPorPagina: Int
)