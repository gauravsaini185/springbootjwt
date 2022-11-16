package com.crud.demo.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


public class  Profile2 {
	
	
	private Integer[] phone;
	private String address;
	
	

	
	public Integer[] getPhone() {
		return phone;
	}
	public void setPhone(Integer[] phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
