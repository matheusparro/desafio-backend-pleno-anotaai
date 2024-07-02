package com.matheusparro.desafio_java_pleno.controllers;

import com.matheusparro.desafio_java_pleno.domain.Category.Category;
import com.matheusparro.desafio_java_pleno.domain.Category.CategoryDTO;
import com.matheusparro.desafio_java_pleno.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryData){
        Category createdCategory = categoryService.createCategory(categoryData);
        return ResponseEntity.ok().body(createdCategory);

    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> update(@PathVariable String categoryId, @RequestBody CategoryDTO categoryData){
        Category updatedCategory = categoryService.updateCategory(categoryId, categoryData);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity delete(@PathVariable String categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
