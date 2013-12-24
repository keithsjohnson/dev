package uk.co.keithsjohnson.test.internal;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.test.TestHello;

public class TestJHelloImplJUnitTest {
	TestHello testSubject;

	@Before
	public void setup() {
		testSubject = new TestHelloImpl();
	}

	@Test
	public void shouldSayHello() {
		testSubject.printHello();
	}

}
