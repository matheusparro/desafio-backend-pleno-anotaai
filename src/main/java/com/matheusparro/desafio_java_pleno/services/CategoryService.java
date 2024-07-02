package com.matheusparro.desafio_java_pleno.services;

import com.matheusparro.desafio_java_pleno.domain.Category.Category;
import com.matheusparro.desafio_java_pleno.domain.Category.CategoryDTO;
import com.matheusparro.desafio_java_pleno.domain.Category.exceptions.CategoryNotFoundException;
import com.matheusparro.desafio_java_pleno.repositories.CategoryRepository;
import com.matheusparro.desafio_java_pleno.services.aws.AwsSnsService;
import com.matheusparro.desafio_java_pleno.services.aws.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AwsSnsService awsSnsService;

    public Category createCategory(CategoryDTO category) {
        Category newCategory = new Category(category);
        categoryRepository.save(newCategory);
        this.awsSnsService.publish(new MessageDTO(newCategory.toString()));
        return newCategory;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(String categoryId, CategoryDTO categoryData) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());
        categoryRepository.save(category);
        this.awsSnsService.publish(new MessageDTO(category.toString()));
        return category;
    }

    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(category);
    }

    public Optional<Category> findById(String category) {
        return categoryRepository.findById(category);
    }
}
