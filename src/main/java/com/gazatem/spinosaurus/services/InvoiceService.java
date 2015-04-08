package com.gazatem.spinosaurus.services;



import com.gazatem.spinosaurus.domain.Invoice;
import com.gazatem.spinosaurus.domain.Product;

public interface InvoiceService {

	public Invoice saveProduct(Invoice invoice, Product product);
}
