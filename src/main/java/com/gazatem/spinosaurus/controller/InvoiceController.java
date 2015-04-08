package com.gazatem.spinosaurus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

import com.gazatem.spinosaurus.domain.Invoice;
import com.gazatem.spinosaurus.domain.Product;
import com.gazatem.spinosaurus.domain.User;
import com.gazatem.spinosaurus.repository.InvoiceRepository;
import com.gazatem.spinosaurus.services.InvoiceServiceImpl;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

	@Autowired
	InvoiceRepository invoiceRepository;
	InvoiceServiceImpl service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Invoice getSingle(@PathVariable int id) {
		Invoice invoice = invoiceRepository.findById(id);
		return invoice;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Invoice create(@AuthenticationPrincipal User user,
			@RequestBody Invoice invoice) {
		invoice.setAccount(user.getAccount());
		invoiceRepository.save(invoice);
		return invoice;
	}

	@RequestMapping(value = "/{id:[\\d]+}/products", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	@ResponseBody
	public void addProducts(@PathVariable("id") int id,
			@RequestBody Product product) {
		Invoice invoice = invoiceRepository.findById((int) id);
		service = new InvoiceServiceImpl(invoiceRepository);
		service.saveProduct(invoice, product);
	}
	
	@RequestMapping(value = "/{id:[\\d]+}/products", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.RESET_CONTENT)
	@ResponseBody
	public void deleteProducts(@PathVariable("id") int id,
			@RequestBody Product product) {
		Invoice invoice = invoiceRepository.findById((int) id);
		service = new InvoiceServiceImpl(invoiceRepository);
		service.deleteProduct(invoice, product);;
	}	
	

}
