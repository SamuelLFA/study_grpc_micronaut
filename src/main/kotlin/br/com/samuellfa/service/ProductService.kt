package br.com.samuellfa.service

import br.com.samuellfa.dto.ProductReq
import br.com.samuellfa.dto.ProductRes

interface ProductService {
    fun create(req: ProductReq): ProductRes
}