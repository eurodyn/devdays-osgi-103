package com.devdays103.impl.it;

import com.devdays103.api.AddressbookService;
import com.devdays103.impl.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class AddressbookServiceImplITTest extends ITTestBasis {
	@Inject
	AddressbookService addressbookService;

	@Test
	public void getAddress() throws Exception {
		assertEquals(TestUtil.LOC_ATHENS, addressbookService.getAddress("ED-ATH"));
		assertEquals(TestUtil.LOC_BRUSSELS, addressbookService.getAddress("ED-BEL"));
		assertEquals(TestUtil.LOC_UK, addressbookService.getAddress("ED-UK"));
	}
}