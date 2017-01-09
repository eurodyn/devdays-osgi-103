package com.devdays103.api;

import com.devdays103.dto.GeocodingReplyDTO;

import java.io.IOException;

public interface GeocodingService {
	GeocodingReplyDTO getGeolocationByAddress(String address) throws IOException;
	GeocodingReplyDTO getGeolocationByBusiness(String businessName) throws IOException;
}
