package com.gazatem.spinosaurus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gazatem.spinosaurus.domain.Invoice;
import com.gazatem.spinosaurus.domain.User;
import com.gazatem.spinosaurus.repository.InvoiceRepository;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

	@Autowired
	InvoiceRepository invoiceRepository;	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Invoice getSingle(@PathVariable int id) {
		Invoice invoice = invoiceRepository.findById(id);
		return invoice;
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Invoice create(@AuthenticationPrincipal User user, @RequestBody Invoice invoice) {
		invoice.setAccount(user.getAccount());
		invoiceRepository.save(invoice);
		return invoice;
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseBody
//	public Invoice products(@AuthenticationPrincipal User user, @RequestBody Invoice invoice) {
//		//invoice.setAccount(user.getAccount());
//		//invoiceRepository.save(invoice);
//		return invoice;
//	}	
	
	
}
