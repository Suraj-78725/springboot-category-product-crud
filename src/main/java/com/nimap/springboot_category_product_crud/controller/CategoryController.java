package com.nimap.springboot_category_product_crud.controller;

import com.nimap.springboot_category_product_crud.entity.CategoryEntity;
import com.nimap.springboot_category_product_crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<CategoryEntity> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return categoryService.getAllCategories(page, size);
    }

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity categoryDetails) {
        CategoryEntity category = categoryService.getCategoryById(id);
        category.setName(categoryDetails.getName());
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);

    }
}
