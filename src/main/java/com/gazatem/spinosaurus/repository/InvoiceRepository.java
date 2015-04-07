package com.gazatem.spinosaurus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gazatem.spinosaurus.domain.Invoice;


public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

	@Query("from Invoice p where p.id = :id")
	Invoice findById(@Param("id") int id);
}
