package com.devdays103.impl;

import com.devdays103.api.AddressbookService;
import com.devdays103.api.GeocodingService;
import com.devdays103.dto.GeocodingReplyDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URLEncoder;

@Singleton
@OsgiServiceProvider(classes = {GeocodingService.class})
public class GeocodingServiceImpl implements GeocodingService {
	@Inject
	AddressbookService addressbookService;

	private static ObjectMapper mapper;

	public GeocodingServiceImpl() {
		mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
	}

	@Override
	public GeocodingReplyDTO getGeolocationByAddress(String address) throws IOException {
		String url = "http://www.datasciencetoolkit.org/text2places/%5B%22" +
				URLEncoder.encode(address, "UTF-8") + "%22%5D";

		GeocodingReplyDTO geocodingReplyDTO;
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(url);
			String proxy = System.getenv("HTTP_PROXY");
			if (proxy != null && !proxy.equals("")) {
				String host = proxy.substring(0, proxy.lastIndexOf(":"));
				int port = Integer.parseInt(proxy.substring(proxy.lastIndexOf(":") + 1));
				System.out.println("Using proxy");
				httpGet.setConfig(RequestConfig.custom()
						.setProxy(new HttpHost(host, port))
						.build());
			}

			String body = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
			geocodingReplyDTO = mapper.readValue(body, GeocodingReplyDTO.class);
		}

		return geocodingReplyDTO;
	}

	@Override
	public GeocodingReplyDTO getGeolocationByBusiness(String businessName) throws IOException {
		return getGeolocationByAddress(
				addressbookService.getAddress(businessName));
	}
}
