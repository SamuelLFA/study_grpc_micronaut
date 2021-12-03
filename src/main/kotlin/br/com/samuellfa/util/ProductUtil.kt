package br.com.samuellfa.util

import br.com.samuellfa.ProductServiceRequest
import br.com.samuellfa.domain.Product
import br.com.samuellfa.dto.ProductReq
import br.com.samuellfa.dto.ProductRes

fun Product.toProductRes(): ProductRes {
    return ProductRes(
        id = id,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun ProductReq.toDomain(): Product {
    return Product(
        id = null,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun ProductServiceRequest.toProductReq(): ProductReq {
    return ProductReq(
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}