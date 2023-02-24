package com.accenture.payroll.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.payroll.model.Payroll;

public interface PayrollRepository extends MongoRepository<Payroll,Integer>{

}
