package com.devdays103.impl.mock;

import com.devdays103.api.AddressbookService;
import com.devdays103.impl.TestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;

import javax.inject.Inject;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class AddressbookServiceImplMockTest extends MockTestBasis {
	@Inject
	AddressbookService addressbookService;

	@Test
	public void getAddress() throws Exception {
		AddressbookService addressbookServiceSpy = spy(addressbookService);
		doReturn(TestUtil.LOC_ATHENS).when(addressbookServiceSpy).getAddress("ED-ATH");
		doReturn(TestUtil.LOC_BRUSSELS).when(addressbookServiceSpy).getAddress("ED-BEL");
		doReturn(TestUtil.LOC_UK).when(addressbookServiceSpy).getAddress("ED-UK");

		Assert.assertEquals(TestUtil.LOC_ATHENS, addressbookServiceSpy.getAddress("ED-ATH"));
		Assert.assertEquals(TestUtil.LOC_BRUSSELS, addressbookServiceSpy.getAddress("ED-BEL"));
		Assert.assertEquals(TestUtil.LOC_UK, addressbookServiceSpy.getAddress("ED-UK"));
	}

}