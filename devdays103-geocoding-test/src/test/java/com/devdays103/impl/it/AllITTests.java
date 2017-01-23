package com.devdays103.impl.mock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		AddressbookServiceImplMockTest.class,
		GeocodingServiceImplMockTest.class
})
public class AllMockTests {

}
