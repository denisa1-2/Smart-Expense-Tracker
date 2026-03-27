package com.denisa.smart_expense_tracker.repository;

import com.denisa.smart_expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId);

    List<Expense> findByCategoryId(Long categoryId);

    @Query("SELECT e.category.name, SUM(e.amount) FROM Expense e GROUP BY e.category.name")
    List<Object[]> getTotalAmountByCategory();

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE MONTH(e.date) = :month AND YEAR(e.date) = :year")
    Double getTotalAmountByMonth(@Param("month") int month, @Param("year") int year);
}
