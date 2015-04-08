package com.gazatem.spinosaurus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gazatem.spinosaurus.domain.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	@Query("from Invoice i where i.id = :id")
	Invoice findById(@Param("id") int id);
	
}
