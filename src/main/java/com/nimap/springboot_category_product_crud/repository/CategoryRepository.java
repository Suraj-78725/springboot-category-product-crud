package com.nimap.springboot_category_product_crud.repository;

import com.nimap.springboot_category_product_crud.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
