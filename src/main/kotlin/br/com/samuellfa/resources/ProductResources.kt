package br.com.samuellfa.resources

import br.com.samuellfa.ProductServiceRequest
import br.com.samuellfa.ProductServiceResponse
import br.com.samuellfa.ProductsServiceGrpc
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResources : ProductsServiceGrpc.ProductsServiceImplBase() {
    override fun create(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceResponse>?) {
        super.create(request, responseObserver)
    }
}