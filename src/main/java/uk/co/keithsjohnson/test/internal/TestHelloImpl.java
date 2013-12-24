package uk.co.keithsjohnson.test.internal;

import uk.co.keithsjohnson.test.TestHello;

public class TestHelloImpl implements TestHello {

	@Override
	public void printHello() {
		System.out.println(TestHelloImpl.class.getSimpleName() + ": Hello!");
	}

}
