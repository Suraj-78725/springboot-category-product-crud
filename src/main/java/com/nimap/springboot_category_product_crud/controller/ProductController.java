package com.nimap.springboot_category_product_crud.controller;

import com.nimap.springboot_category_product_crud.entity.CategoryEntity;
import com.nimap.springboot_category_product_crud.entity.ProductEntity;
import com.nimap.springboot_category_product_crud.repository.CategoryRepository;
import com.nimap.springboot_category_product_crud.repository.ProductRepository;
import com.nimap.springboot_category_product_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "5") int size) {
        return productService.getAllProducts(page, size);
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product, @RequestParam Long categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable Long id,
                                 @RequestBody ProductEntity productDetails) {
        ProductEntity product = productService.getProductById(id);
        Long categoryId = product.getCategory().getId();
        CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(category);

        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}