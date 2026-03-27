package com.denisa.smart_expense_tracker.service;

import com.denisa.smart_expense_tracker.dto.CreateCategoryRequest;
import com.denisa.smart_expense_tracker.exception.DuplicateResourcesException;
import com.denisa.smart_expense_tracker.model.Category;
import com.denisa.smart_expense_tracker.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CreateCategoryRequest request){
        categoryRepository.findByName(request.getName())
                .ifPresent(c -> {
                    throw new DuplicateResourcesException("Category already exists");
                });

        Category category = Category.builder().name(request.getName()).build();

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
