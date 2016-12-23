package com.edge.service;

import java.util.List;

import com.edge.model.Address;
import com.edge.model.AddressValidate;
import com.edge.model.Coordinate;
import com.edge.model.GeoAddress;
import com.edge.model.Street;

public interface AddressGatewayService {
	
	List<Address> getAddressDetails(String country, String addressFragment);
	List<GeoAddress> getGeoAddressDetails(String addressFragment);
	List<Coordinate> getCoordinateDetails(String addressFragment);
	List<Address> getReverseAddressDetails(String latitude, String longitude, String distance);

	List<Street> getStreetDetails(String addressFragment);
	AddressValidate getAddressValidationDetails(String addressFragment);
}
