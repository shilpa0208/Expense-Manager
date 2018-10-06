package org.expense.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.expense.app.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>{

}
