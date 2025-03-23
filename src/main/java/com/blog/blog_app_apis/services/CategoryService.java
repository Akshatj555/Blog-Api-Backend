package com.blog.blog_app_apis.services;

import com.blog.blog_app_apis.entities.Category;
import com.blog.blog_app_apis.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    CategoryDto getCategory(Integer categoryId);

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void deleteCategory(Integer categoryId);

}
