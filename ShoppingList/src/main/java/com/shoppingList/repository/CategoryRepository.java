package com.bookStore.repository;

import com.bookStore.model.entity.Category;
import com.bookStore.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category>findByName(CategoryName name);

}
