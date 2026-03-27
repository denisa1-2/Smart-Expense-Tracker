package com.denisa.smart_expense_tracker.service;

import com.denisa.smart_expense_tracker.dto.CreateExpenseRequest;
import com.denisa.smart_expense_tracker.exception.ResourceNotFoundException;
import com.denisa.smart_expense_tracker.model.Category;
import com.denisa.smart_expense_tracker.model.Expense;
import com.denisa.smart_expense_tracker.model.User;
import com.denisa.smart_expense_tracker.repository.CategoryRepository;
import com.denisa.smart_expense_tracker.repository.ExpenseRepository;
import com.denisa.smart_expense_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public Expense createExpense(CreateExpenseRequest request){
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Expense expense = Expense.builder()
                .amount(request.getAmount())
                .description(request.getDescription())
                .date(request.getDate())
                .user(user)
                .category(category)
                .build();

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByUser(Long userId){
        return expenseRepository.findByUserId(userId);
    }

    public List<Expense> getExpensesByCategory(Long categoryId){
        return expenseRepository.findByCategoryId(categoryId);
    }

    public Map<String, Double> getTotalByCategory(){
        List<Object[]> results = expenseRepository.getTotalAmountByCategory();

        Map<String, Double> response = new HashMap<>();

        for(Object[] row : results){
            String category = (String) row[0];
            Double total = (Double) row[1];

            response.put(category, total);
        }

        return response;
    }

    public Double getTotalByMonth(int month, int year){
        Double total = expenseRepository.getTotalAmountByMonth(month, year);
        return total != null ? total : 0.0;
    }

    public void deleteExpense(Long id){
        Expense expense = expenseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Espense not found"));

        expenseRepository.delete(expense);
    }
}
