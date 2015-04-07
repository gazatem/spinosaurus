package com.gazatem.spinosaurus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gazatem.spinosaurus.domain.Product;
import com.gazatem.spinosaurus.domain.User;
import com.gazatem.spinosaurus.repository.ProductRepository;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Product getSingle(@PathVariable int id) {
		Product product = productRepository.findById(id);
		return product;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Product create(@AuthenticationPrincipal User user, @RequestBody Product product) {
		product.setAccount(user.getAccount());
		productRepository.save(product); 
		return product;
	}	

	@RequestMapping(value ="/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Product update(@AuthenticationPrincipal User user, @PathVariable int id, @RequestBody Product product) {
		product.setAccount(user.getAccount());
		product.setId(id);
		productRepository.save(product);
		return product;
	}	


}
