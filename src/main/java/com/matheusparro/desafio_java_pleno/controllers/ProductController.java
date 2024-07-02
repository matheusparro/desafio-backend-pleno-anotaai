package com.matheusparro.desafio_java_pleno.controllers;
import com.matheusparro.desafio_java_pleno.domain.Product.Product;
import com.matheusparro.desafio_java_pleno.domain.Product.ProductDTO;
import com.matheusparro.desafio_java_pleno.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productData){
        Product createdProduct = productService.createProduct(productData);
        return ResponseEntity.ok().body(createdProduct);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable String productId, @RequestBody ProductDTO productData){
        Product updatedProduct = productService.updateProduct(productId, productData);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity delete(@PathVariable String productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
