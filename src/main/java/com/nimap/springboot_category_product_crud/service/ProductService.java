package com.nimap.springboot_category_product_crud.service;

import com.nimap.springboot_category_product_crud.entity.CategoryEntity;
import com.nimap.springboot_category_product_crud.entity.ProductEntity;
import com.nimap.springboot_category_product_crud.repository.CategoryRepository;
import com.nimap.springboot_category_product_crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<ProductEntity> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity getProductById( Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(  Long id) {
        productRepository.deleteById(id);
    }

}
