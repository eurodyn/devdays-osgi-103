package com.devdays103;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest2 {
	@Test
	public void addition() throws Exception {
		Calculator calculator = new Calculator();
		int result = calculator.addition(10, 5);
		Assert.assertEquals(15, result);
	}

	@Test
	public void subtraction() throws Exception {
		Calculator calculator = new Calculator();
		int result = calculator.subtraction(10, 5);
		Assert.assertEquals(5, result);
	}
}