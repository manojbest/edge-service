package com.edge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edge.model.Response;
import com.edge.service.AddressGatewayServiceImpl;

@RestController
@RequestMapping("/{country-code}/postcoder")
public class AddressGatewayController {
	
	@Autowired
	private AddressGatewayServiceImpl addressGatewayService;
	
	@RequestMapping(value = "/address/{eircode-or-address-fragment}", method = RequestMethod.GET)
	public ResponseEntity<Response> handleAddressLookup(@PathVariable("country-code") String country, @PathVariable("eircode-or-address-fragment") String inputValue){
		final Response response = new Response();
		response.setStatus("success");		
		response.setData(addressGatewayService.getAddressDetails(country, inputValue));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addressgeo/{eircode-or-address-fragment}", method = RequestMethod.GET)
	public ResponseEntity<Response> handleGeoAddressLookup(@PathVariable("eircode-or-address-fragment") String inputValue){
		final Response response = new Response();
		response.setStatus("success");		
		response.setData(addressGatewayService.getGeoAddressDetails(inputValue));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/position/{eircode-or-address-fragment}", method = RequestMethod.GET)
	public ResponseEntity<Response> handlePositionLookup(@PathVariable("eircode-or-address-fragment") String inputValue){
		final Response response = new Response();
		response.setStatus("success");		
		response.setData(addressGatewayService.getCoordinateDetails(inputValue));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rgeoaddress/{latitude}/{longitude}/{distance}", method = RequestMethod.GET)
	public ResponseEntity<Response> handleReverseAddressLookup(@PathVariable("latitude") final String latitude,
			@PathVariable("longitude") final String longitude, @PathVariable("distance") final String distance){
		final Response response = new Response();
		response.setStatus("success");		
		response.setData(addressGatewayService.getReverseAddressDetails(latitude, longitude, distance));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/street/{ukcode-or-address-fragment}", method = RequestMethod.GET)
	public ResponseEntity<Response> handleStreetLookup(@PathVariable("ukcode-or-address-fragment") String inputValue){
		final Response response = new Response();
		response.setStatus("success");		
		response.setData(addressGatewayService.getStreetDetails(inputValue));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/address/validate/{ukcode-or-address-fragment}", method = RequestMethod.GET)
	public ResponseEntity<Response> handleValidateAddressLookup(@PathVariable("ukcode-or-address-fragment") String inputValue){
		final Response response = new Response();
		response.setStatus("success");		
		response.setData(addressGatewayService.getAddressValidationDetails(inputValue));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
