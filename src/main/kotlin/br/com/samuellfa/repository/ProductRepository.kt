package br.com.samuellfa.repository

import br.com.samuellfa.domain.Product
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ProductRepository : JpaRepository<Product, Long>