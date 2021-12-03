package br.com.samuellfa.resources

import br.com.samuellfa.ProductServiceRequest
import br.com.samuellfa.ProductServiceResponse
import br.com.samuellfa.ProductsServiceGrpc
import br.com.samuellfa.service.ProductService
import br.com.samuellfa.util.toProductReq
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResources(private val productService: ProductService) : ProductsServiceGrpc.ProductsServiceImplBase() {
    override fun create(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceResponse>?) {
        val productReq = request?.toProductReq()
        val productRes = productService.create(productReq!!)

        val productServiceResponse = ProductServiceResponse
            .newBuilder()
            .setId(productRes.id!!)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(productServiceResponse)
        responseObserver?.onCompleted()

    }
}