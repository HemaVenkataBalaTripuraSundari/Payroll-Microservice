package com.accenture.payroll.service;

import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.accenture.payroll.dao.PayrollRepository;
import com.accenture.payroll.model.Payroll;

@Service
public class PayrollService {

	@Autowired
	private PayrollRepository repo;

	public Optional<Payroll> getPayrollDetails(int id) {
		return repo.findById(id);
	}

	@KafkaListener(topics = {"#{'${kafka.consumer.topic}'}"})
    public void receive(@Payload String message) {

		try {
			JSONObject incomingJson = new JSONObject(message);
			System.out.println(incomingJson);
	        Optional<Payroll> payrollData = getPayrollDetails(incomingJson.getInt("employeeId"));
	        if (payrollData.isPresent()) {
	        	Payroll payroll = payrollData.get();
	        	payroll.setMonthlySalary(incomingJson.getDouble("salary")/12);
	        	repo.save(payroll);
	        }
		}catch(JSONException e) {
			System.out.println("Unable to extract payroll details: {}"+e);
		}
    }

}
