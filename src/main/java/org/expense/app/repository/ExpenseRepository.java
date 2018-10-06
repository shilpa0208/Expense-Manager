package org.expense.app.repository;

import org.expense.app.model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Integer>{

}
