package com.gazatem.spinosaurus.domain;

import java.sql.Date;

import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="invoices")
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
