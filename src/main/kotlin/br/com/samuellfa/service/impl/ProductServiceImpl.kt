package br.com.samuellfa.service.impl

import br.com.samuellfa.domain.Product
import br.com.samuellfa.dto.ProductReq
import br.com.samuellfa.dto.ProductRes
import br.com.samuellfa.repository.ProductRepository
import br.com.samuellfa.service.ProductService
import br.com.samuellfa.util.toDomain
import br.com.samuellfa.util.toProductRes
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun create(req: ProductReq): ProductRes {
        val product = req.toDomain()
        val productSaved = productRepository.save(product)

        return productSaved.toProductRes()
    }
}