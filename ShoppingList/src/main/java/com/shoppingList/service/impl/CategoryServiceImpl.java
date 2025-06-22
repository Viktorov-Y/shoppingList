package com.bookStore.service.impl;

import com.bookStore.model.entity.Category;
import com.bookStore.model.entity.enums.CategoryName;
import com.bookStore.repository.CategoryRepository;
import com.bookStore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()).forEach(categoryName -> {
                Category category = new Category(categoryName,
                        "Description for " + categoryName.name());
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return categoryRepository
                .findByName(categoryName).orElse(null);
    }

}
