package com.gazatem.spinosaurus.domain;

import java.sql.Date;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	private String name;

	@Nullable
	private Date invoiceDate;

	@Nullable
	private String invoiceSerie;

	@Nullable
	private String invoiceNo;

	@Nullable
	private double total;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	@ManyToMany
	@JoinTable(joinColumns = { @JoinColumn(name = "invoice_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id") })
	private List<Product> products;


	public Invoice(String name, Date invoiceDate, String invoiceSerie,
			String invoiceNo, double total, Account account,
			List<Product> products) {
		super();
		this.name = name;
		this.invoiceDate = invoiceDate;
		this.invoiceSerie = invoiceSerie;
		this.invoiceNo = invoiceNo;
		this.total = total;
		this.account = account;
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceSerie() {
		return invoiceSerie;
	}

	public void setInvoiceSerie(String invoiceSerie) {
		this.invoiceSerie = invoiceSerie;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(String name, Date invoiceDate, String invoiceSerie,
			String invoiceNo, double total, Account account) {
		super();
		this.name = name;
		this.invoiceDate = invoiceDate;
		this.invoiceSerie = invoiceSerie;
		this.invoiceNo = invoiceNo;
		this.total = total;
		this.account = account;
	}

}
