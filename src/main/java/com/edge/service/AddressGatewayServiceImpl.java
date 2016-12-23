package com.edge.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edge.model.Address;
import com.edge.model.AddressValidate;
import com.edge.model.Coordinate;
import com.edge.model.GeoAddress;
import com.edge.model.Street;

@Service
public class AddressGatewayServiceImpl implements AddressGatewayService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${eircodeservice.address.lookup.url}")
	private String eirAddressLookupUri;
	
	@Value("${ukcodeservice.address.lookup.url}")
	private String ukAddressLookupUri;
	
	@Value("${eircodeservice.geoaddress.lookup.url}")
	private String geoAddressLookupUri;
	
	@Value("${eircodeservice.coordinate.lookup.url}")
	private String coordinateLookupUri;
	
	@Value("${eircodeservice.raddress.lookup.url}")
	private String reverseAddressLookupUri;
	
	@Value("${ukcodeservice.street.lookup.url}")
	private String streetLookupUri;
	
	@Value("${ukcodeservice.address.validate.lookup.url}")
	private String addressValidateLookupUri;
	
	@Override
	public List<Address> getAddressDetails(final String country, final String addressFragment) {
		ResponseEntity<Address[]> result = null;
		if ("uk".equalsIgnoreCase(country)) {
			result = restTemplate.getForEntity(ukAddressLookupUri.replace("{address-fragment}", addressFragment), Address[].class);
		} else if ("eir".equalsIgnoreCase(country)) {
			result = restTemplate.getForEntity(eirAddressLookupUri.replace("{address-fragment}", addressFragment), Address[].class);
		}
		return Arrays.asList(result.getBody());
	}

	@Override
	public List<GeoAddress> getGeoAddressDetails(String addressFragment) {
		final ResponseEntity<GeoAddress[]> result = restTemplate.getForEntity(geoAddressLookupUri.replace("{address-fragment}", addressFragment), GeoAddress[].class);
		return Arrays.asList(result.getBody());
	}

	@Override
	public List<Coordinate> getCoordinateDetails(String addressFragment) {
		final ResponseEntity<Coordinate[]> result = restTemplate.getForEntity(coordinateLookupUri.replace("{address-fragment}", addressFragment), Coordinate[].class);
		return Arrays.asList(result.getBody());
	}

	@Override
	public List<Address> getReverseAddressDetails(String latitude, String longitude, String distance) {
		final ResponseEntity<Address[]> result = restTemplate.getForEntity(reverseAddressLookupUri.replace("{latitude}", latitude)
				.replace("{longitude}", longitude).replace("{distance}", distance), Address[].class);
		return Arrays.asList(result.getBody());
	}

	@Override
	public List<Street> getStreetDetails(String addressFragment) {
		final ResponseEntity<Street[]> result = restTemplate.getForEntity(streetLookupUri.replace("{address-fragment}", addressFragment), Street[].class);
		return Arrays.asList(result.getBody());
	}

	@Override
	public AddressValidate getAddressValidationDetails(String addressFragment) {
		final ResponseEntity<AddressValidate> result = restTemplate.getForEntity(addressValidateLookupUri.replace("{address-fragment}", addressFragment), AddressValidate.class);
		return result.getBody();
	}

}
