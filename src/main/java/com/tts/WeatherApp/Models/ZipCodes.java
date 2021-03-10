package com.tts.WeatherApp.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ZipCodes {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long id;
    private String zipCode;
    
    @CreationTimestamp
    private Date createdAt;
    
   
	public ZipCodes(Long id, String zipCode) {
		this.id = id;
		this.zipCode = zipCode;
	}
	public ZipCodes() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "ZipCodes [id=" + id + ", zipCode=" + zipCode + "]";
	}
}