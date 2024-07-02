package com.matheusparro.desafio_java_pleno.repositories;

import com.matheusparro.desafio_java_pleno.domain.Product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
}
