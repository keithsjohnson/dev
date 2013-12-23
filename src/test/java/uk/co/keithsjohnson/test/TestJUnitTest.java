package uk.co.keithsjohnson.test;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.test.TestHelloImpl;

public class TestJUnitTest {
	TestHelloImpl testSubjecTest;

	@Before
	public void setup() {
		testSubjecTest = new TestHelloImpl();
	}
	
	@Test
	public void shouldSayHello() {
		testSubjecTest.printHello();
	}

}
