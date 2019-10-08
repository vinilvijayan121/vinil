package com.fab.retaildiscount.discountcalculator.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fab.retaildiscount.discountcalculator.customer.vo.Customer;
import com.fab.retaildiscount.discountcalculator.util.ValidateUtil;

@Component
public class DiscountVoDaoImpl implements DiscountVoDao {
	@Autowired
	ValidateUtil validateUtil;

	@Override
	public double calculateDiscountForCustomer(Customer CustomerVo, double dTotal) {
		// TODO Auto-generated method stub
		double dTotDiscount = 0;
		if (validateUtil.pNullCheck.test(CustomerVo)) {

			if (validateUtil.pEmployee.test(CustomerVo)) {
				dTotDiscount = dTotal * 30 / 100;
			} else if (validateUtil.pAffiliate.test(CustomerVo)) {
				dTotDiscount = dTotal * 20 / 100;
			} else if (validateUtil.hasyearGreaterThan2(CustomerVo)) {
				dTotDiscount = dTotal * 5 / 100;
			} else {
				dTotDiscount = 0;
			}

		}

		return dTotDiscount;
	}

	@Override
	public double calculateDiscountOnbillAmount(double dTotal) {
		// TODO Auto-generated method stub
		int occurance = (int) dTotal / 100;
		return occurance * 5;

	}

}
