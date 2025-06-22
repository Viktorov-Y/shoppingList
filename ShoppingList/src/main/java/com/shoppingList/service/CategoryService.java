package com.bookStore.service;

import com.bookStore.model.entity.Category;
import com.bookStore.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();
    Category findByName(CategoryName categoryName);
}
