package com.devdays103;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private static Calculator calculator;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Creating a new test instance of Calculator.");
		calculator = new Calculator();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Tearing down test instance of Calculator.");
		calculator = null;
	}

	@Before
	public void before() {
		System.out.println("About to test a method.");
	}

	@After
	public void after() {
		System.out.println("Finished method testing.");
	}

	@Test
	public void addition() throws Exception {
		assertEquals(15, calculator.addition(10, 5));
	}

	@Test
	public void subtraction() throws Exception {
		assertEquals(5, calculator.subtraction(10, 5));
	}
}