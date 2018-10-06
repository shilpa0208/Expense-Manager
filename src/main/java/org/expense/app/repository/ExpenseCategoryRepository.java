package org.expense.app.repository;

import org.expense.app.model.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory, Integer>{
	
	public ExpenseCategory findExpenseCategoryByCode(String code);
}
