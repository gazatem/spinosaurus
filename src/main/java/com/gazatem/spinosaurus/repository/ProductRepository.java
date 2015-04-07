package com.gazatem.spinosaurus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
import com.gazatem.spinosaurus.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("from Product p where p.id = :id")
	Product findById(@Param("id") int id);

	List<Product> findAll();
	
	
}
