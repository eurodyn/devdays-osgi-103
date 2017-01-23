package com.devdays103.impl.mock;

import com.devdays103.api.GeocodingService;
import com.devdays103.impl.TestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import javax.inject.Inject;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class GeocodingServiceImplMockTest extends MockTestConf {
	@Inject
	GeocodingService geocodingService;

	@Test
	public void getGeolocationByAddress() throws Exception {
		GeocodingService geocodingServiceSpy = spy(geocodingService);
		doReturn(TestUtil.GEO_ATHENS)
				.when(geocodingServiceSpy).getGeolocationByAddress(TestUtil.LOC_ATHENS);
		doReturn(TestUtil.GEO_BELGIUM)
				.when(geocodingServiceSpy).getGeolocationByAddress(TestUtil.LOC_BRUSSELS);
		doReturn(TestUtil.GEO_UK)
			.when(geocodingServiceSpy).getGeolocationByAddress(TestUtil.LOC_UK);

		Assert.assertEquals(TestUtil.GEO_ATHENS,
				geocodingServiceSpy.getGeolocationByAddress(TestUtil.LOC_ATHENS));
		Assert.assertEquals(TestUtil.GEO_BELGIUM,
				geocodingServiceSpy.getGeolocationByAddress(TestUtil.LOC_BRUSSELS));
		Assert.assertEquals(TestUtil.GEO_UK,
				geocodingServiceSpy.getGeolocationByAddress(TestUtil.LOC_UK));
	}

	@Test
	public void getGeolocationByBusiness() throws Exception {
		GeocodingService geocodingServiceSpy = spy(geocodingService);
		doReturn(TestUtil.GEO_ATHENS)
				.when(geocodingServiceSpy).getGeolocationByBusiness("ED-ATH");
		doReturn(TestUtil.GEO_BELGIUM)
				.when(geocodingServiceSpy).getGeolocationByBusiness("ED-BEL");
		doReturn(TestUtil.GEO_UK)
				.when(geocodingServiceSpy).getGeolocationByBusiness("ED-UK");

		Assert.assertEquals(TestUtil.GEO_ATHENS,
				geocodingServiceSpy.getGeolocationByBusiness("ED-ATH"));
		Assert.assertEquals(TestUtil.GEO_BELGIUM,
				geocodingServiceSpy.getGeolocationByBusiness("ED-BEL"));
		Assert.assertEquals(TestUtil.GEO_UK,
				geocodingServiceSpy.getGeolocationByBusiness("ED-UK"));
	}

}