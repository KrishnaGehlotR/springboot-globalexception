package org.dev.springbootcrud.service.impl;

import java.util.List;

import org.dev.springbootcrud.customexception.EmptyInputException;
import org.dev.springbootcrud.entities.PaytmBank;
import org.dev.springbootcrud.repositories.PaytmBankRepositories;
import org.dev.springbootcrud.service.PaytmBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaytmBankServiceImpl implements PaytmBankService {

	@Autowired
	PaytmBankRepositories paytmBankRepositories;

	@Override
	public PaytmBank addPayment(PaytmBank paytmBank) {
		if (paytmBank.getName().isEmpty() || paytmBank.getName().length() == 0) {
			throw new EmptyInputException("601", "Please send proper name, It cannot be blank");
		}

		return paytmBankRepositories.save(paytmBank);
	}

	@Override
	public List<PaytmBank> getAllPayments() {
		List<PaytmBank> paytmBanks = paytmBankRepositories.findAll();

		if (paytmBanks.isEmpty() || paytmBanks == null) {
			throw new EmptyInputException("605", "We do not have payment to show, add some payment to records");
		}

		return paytmBanks;
	}

	@Override
	public PaytmBank getPaymentById(Long id) {
		return paytmBankRepositories.findById(id).get();
	}

	@Override
	public void deletePaymentById(Long idL) {
		paytmBankRepositories.deleteById(idL);
	}

}
