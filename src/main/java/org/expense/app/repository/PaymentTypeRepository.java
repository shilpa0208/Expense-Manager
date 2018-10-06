package org.expense.app.repository;

import org.expense.app.model.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Integer>{

}
