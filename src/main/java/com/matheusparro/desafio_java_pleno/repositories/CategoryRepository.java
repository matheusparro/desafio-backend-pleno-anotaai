package com.matheusparro.desafio_java_pleno.repositories;

import com.matheusparro.desafio_java_pleno.domain.Category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
