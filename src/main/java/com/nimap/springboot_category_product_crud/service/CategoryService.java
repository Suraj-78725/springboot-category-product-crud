package com.nimap.springboot_category_product_crud.service;

import com.nimap.springboot_category_product_crud.entity.CategoryEntity;
import com.nimap.springboot_category_product_crud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<CategoryEntity> getAllCategories(int page , int size){
        return categoryRepository.findAll(PageRequest.of(page,size));
    }

    public CategoryEntity createCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory( Long id) {
        categoryRepository.deleteById(id);
    }

}
