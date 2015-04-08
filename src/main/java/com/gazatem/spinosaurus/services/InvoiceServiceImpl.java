package com.gazatem.spinosaurus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gazatem.spinosaurus.domain.Invoice;
import com.gazatem.spinosaurus.domain.Product;
import com.gazatem.spinosaurus.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository invoiceRepository;

	@Autowired
	public InvoiceServiceImpl(final InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	@Transactional
	public Invoice saveProduct(Invoice invoice, Product product) {
		invoice.getProducts().add(product);
		invoice = invoiceRepository.save(invoice);
		System.out.println(invoice.toString());
		return invoice;
	}

}
