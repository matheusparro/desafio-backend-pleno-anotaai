package com.matheusparro.desafio_java_pleno.services;

import com.matheusparro.desafio_java_pleno.domain.Category.Category;
import com.matheusparro.desafio_java_pleno.domain.Category.CategoryDTO;
import com.matheusparro.desafio_java_pleno.domain.Category.exceptions.CategoryNotFoundException;
import com.matheusparro.desafio_java_pleno.domain.Product.Product;
import com.matheusparro.desafio_java_pleno.domain.Product.ProductDTO;
import com.matheusparro.desafio_java_pleno.domain.Product.exceptions.ProductNotFoundException;
import com.matheusparro.desafio_java_pleno.repositories.CategoryRepository;
import com.matheusparro.desafio_java_pleno.repositories.ProductRepository;
import com.matheusparro.desafio_java_pleno.services.aws.AwsSnsService;
import com.matheusparro.desafio_java_pleno.services.aws.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AwsSnsService awsSnsService;

    public Product createProduct(ProductDTO product) {
        this.categoryService.findById(product.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(product);
        this.productRepository.save(newProduct);
        this.awsSnsService.publish(new MessageDTO(newProduct.toString()));
        return newProduct;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product updateProduct(String productId, ProductDTO productData) {
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(productData.price() != null) product.setPrice(productData.price());
        if(productData.categoryId()!= null) {
            this.categoryService.findById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
            product.setCategory(productData.categoryId());
        }
        productRepository.save(product);

        this.awsSnsService.publish(new MessageDTO(product.toString()));

        return product;
    }

    public void deleteProduct(String productId){
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }

}
