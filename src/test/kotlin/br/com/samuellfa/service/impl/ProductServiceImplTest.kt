package br.com.samuellfa.service.impl

import br.com.samuellfa.domain.Product
import br.com.samuellfa.dto.ProductReq
import br.com.samuellfa.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

internal class ProductServiceImplTest {

    private val productRepository = Mockito.mock(ProductRepository::class.java)
    private val productService = ProductServiceImpl(productRepository)

    @Test
    fun `where create method is called with valid data, a ProductRes is returned`() {
        val product = Product(
            id = null,
            name = "product",
            price = 10.00,
            quantityInStock = 5
        )
        val productSaved = product.copy(id = 1)
        `when`(productRepository.save(product)).thenReturn(productSaved)

        val productReq = ProductReq(
            name = product.name,
            price = product.price,
            quantityInStock = product.quantityInStock
        )

        val productRes = productService.create(productReq)

        assertEquals(productRes.id, 1)
        assertEquals(productRes.name, product.name)
        assertEquals(productRes.price, product.price)
        assertEquals(productRes.quantityInStock, product.quantityInStock)
    }
}