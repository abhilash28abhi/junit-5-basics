package com.java.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

//By default junit creates new instances of MathUtilsTest for each test method
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {
	
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit () {
		System.out.println("This runs even before the instance of this class is created so this method needs to be static..");
	}
	
	@BeforeEach
	void init (TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up...");
	}
	
	@Nested
	@Tag("Math")
	//Tags can be used to run a group of tests selectively in run configurations
	@DisplayName("Add methods")
	//using nested class to group different test methods together
	class AddTest {
		
		@Test
		@DisplayName("adding two positive numbers correctly")
		void testAddPositive() {
			int actual = mathUtils.add(5, 4);
			assertEquals(8, actual, "should return the right sum");
		}

		@Test
		@DisplayName("adding two negative numbers correctly")
		void testAddNegative() {
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			//passing the string message in lambda would be evaluated only if the test fails
			assertEquals(expected, actual , () -> "should return sum " + expected + " but returned " + actual);
		}
	}

	@Test
	@Tag("Math")
	@DisplayName("Multiply method")
	void testMultiply() {
		//assertEquals(4, mathUtils.multiply(2, 2), "Should return the right product");
		//assertAll will evaluate all the asserts its like a and condition
		assertAll(
				() -> assertEquals(0, mathUtils.multiply(0, 2)),
				() -> assertEquals(1, mathUtils.multiply(1, 1)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1)),
				() -> assertEquals(4, mathUtils.multiply(2, 2))
				);
	}
	
	@Test
	@Tag("Math")
	void testDivide() {
		//assumption annotations if the condition is met only then proceed else skip the test
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
	}
	
	@RepeatedTest(3)
	@Tag("Circle")
	void testComputeCircleArea(RepetitionInfo repetitionInfo) {
		if (repetitionInfo.getCurrentRepetition() == 2) {
			System.out.println("2nd run");
		}
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
	}
	
	@Test
	@DisplayName("Testing disabled method")
	@Disabled
	void testDisabled() {
		fail("This method should be disabled");
	}
}
