package com.crud.demo.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="profile")
public class  Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	@Column(name = "phone", columnDefinition = "int[]")
	@Type(type = "com.crud.demo.entity.CustomIntegerArrayType")
	private Integer[] phone;
	private String address="abc";
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
