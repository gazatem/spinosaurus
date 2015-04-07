package com.gazatem.spinosaurus.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	private String name;

	@NotNull 
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;		
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;			
	
	  @ManyToMany(mappedBy="products")
	  private List<Invoice> invoices;
	
	
	public Category getCategory() {
		return category;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product(String name, double price, Account account) {
		super();
		this.name = name;
		this.price = price;
		this.account = account;
	}
	

	public Product(String name, double price, Account account, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.account = account;
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
	
	

}
