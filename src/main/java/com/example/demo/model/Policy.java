package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Component
@Entity

public class Policy {
	@Id
	String policyid;
	String loginid;
	String policyname;
	String insurance_tenure;
	String premium_amount;
	String sum_insured;
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPolicyname() {
		return policyname;
	}
	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}
	public String getInsurance_tenure() {
		return insurance_tenure;
	}
	public void setInsurance_tenure(String insurance_tenure) {
		this.insurance_tenure = insurance_tenure;
	}
	public String getPremium_amount() {
		return premium_amount;
	}
	public void setPremium_amount(String premium_amount) {
		this.premium_amount = premium_amount;
	}
	public String getSum_insured() {
		return sum_insured;
	}
	public void setSum_insured(String sum_insured) {
		this.sum_insured = sum_insured;
	}
	
	
	
}
