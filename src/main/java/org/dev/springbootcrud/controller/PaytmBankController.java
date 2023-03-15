package org.dev.springbootcrud.controller;

import java.util.List;

import org.dev.springbootcrud.entities.PaytmBank;
import org.dev.springbootcrud.service.PaytmBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class PaytmBankController {

	@Autowired
	private PaytmBankService paytmBankService;

	@PostMapping("/payment/add")
	public ResponseEntity<?> addPayment(@RequestBody PaytmBank paytmBank) {
		PaytmBank addPayment = paytmBankService.addPayment(paytmBank);
		return new ResponseEntity<PaytmBank>(addPayment, HttpStatus.CREATED);
	}

	@GetMapping("/payment/all")
	public ResponseEntity<List<PaytmBank>> getAllPayments() {
		List<PaytmBank> listOfPayments = paytmBankService.getAllPayments();
		return new ResponseEntity<List<PaytmBank>>(listOfPayments, HttpStatus.OK);
	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable("id") Long idL) {
		PaytmBank paymentRetrieved = paytmBankService.getPaymentById(idL);
		return new ResponseEntity<PaytmBank>(paymentRetrieved, HttpStatus.OK);
	}

	@PutMapping("/payment/update")
	public ResponseEntity<?> updatePayment(@RequestBody PaytmBank paytmBank) {
		PaytmBank addPayment = paytmBankService.addPayment(paytmBank);
		return new ResponseEntity<PaytmBank>(addPayment, HttpStatus.CREATED);
	}

	@DeleteMapping("/payment/{id}")
	public ResponseEntity<?> deletePaymentById(@PathVariable("id") Long idL) {
		paytmBankService.deletePaymentById(idL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
