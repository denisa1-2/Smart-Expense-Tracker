package com.denisa.smart_expense_tracker.controller;

import com.denisa.smart_expense_tracker.dto.CreateExpenseRequest;
import com.denisa.smart_expense_tracker.model.Expense;
import com.denisa.smart_expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@Valid @RequestBody CreateExpenseRequest request){
        return expenseService.createExpense(request);
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUser(@PathVariable Long userId){
        return expenseService.getExpensesByUser(userId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Expense> getExpensesByCategory(@PathVariable Long categoryId){
        return expenseService.getExpensesByCategory(categoryId);
    }

    @GetMapping("/stats/category")
    public Map<String, Double> getStatsByCategory(){
        return expenseService.getTotalByCategory();
    }

    @GetMapping("/stats/month")
    public Double getStatsByMonth(@RequestParam int month, @RequestParam int year){
        return expenseService.getTotalByMonth(month, year);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return "Expense deleted successfully";
    }
}
