package uk.co.keithsjohnson.test.internal;

import org.junit.Before;
import org.junit.Test;

public class TestJHelloImplJUnitTest {
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
