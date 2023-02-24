package com.accenture.payroll.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.payroll.model.Payroll;
import com.accenture.payroll.service.PayrollService;


@RestController
public class PayrollController {

	@Autowired
	private PayrollService payrollService;

	@RequestMapping(value = "payroll/controller/getPayrollDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payroll> getPayrollDetails(@PathVariable("id") int myId) {
		Optional<Payroll> payroll = payrollService.getPayrollDetails(myId);

		if (payroll.isPresent()) {
			return new ResponseEntity<Payroll>(payroll.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Payroll>(HttpStatus.NOT_FOUND);
		}
	}

}
