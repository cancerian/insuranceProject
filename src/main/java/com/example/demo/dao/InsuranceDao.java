package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Insurance;

public interface InsuranceDao extends CrudRepository<Insurance, String> {

	

}

