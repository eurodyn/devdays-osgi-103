package com.devdays103.impl.it;

import com.devdays103.api.GeocodingService;
import com.devdays103.impl.TestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import javax.inject.Inject;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class GeocodingServiceImplITTest extends ITTestConf {
	@Inject
	GeocodingService geocodingService;

	@Test
	public void getGeolocationByAddress() throws Exception {
		Assert.assertEquals(TestUtil.GEO_ATHENS,
				geocodingService.getGeolocationByAddress(TestUtil.LOC_ATHENS));
		Assert.assertEquals(TestUtil.GEO_BELGIUM,
				geocodingService.getGeolocationByAddress(TestUtil.LOC_BRUSSELS));
		Assert.assertEquals(TestUtil.GEO_UK,
				geocodingService.getGeolocationByAddress(TestUtil.LOC_UK));
	}

	@Test
	public void getGeolocationByBusiness() throws Exception {
		Assert.assertEquals(TestUtil.GEO_ATHENS,
				geocodingService.getGeolocationByBusiness("ED-ATH"));
		Assert.assertEquals(TestUtil.GEO_BELGIUM,
				geocodingService.getGeolocationByBusiness("ED-BEL"));
		Assert.assertEquals(TestUtil.GEO_UK,
				geocodingService.getGeolocationByBusiness("ED-UK"));
	}
}