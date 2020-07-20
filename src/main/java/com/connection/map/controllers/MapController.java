/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.connection.map.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connection.map.services.MapService;

import io.swagger.annotations.Api;


/**
 * Rest controller class that can be used to expose the rest API methods.
 * Contains the methods to check two cities are connected. 
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */
@Api
@RestController
@RequestMapping("/map")
public class MapController {

	private Logger log = LoggerFactory.getLogger(MapController.class);
	
	@Autowired
	private MapService mapService;

	
	/**
	 * Rest end-point which returns a list of supported city names.
	 * 
	 * @return List<String>
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<String> listAll() {
		List<String> cities = new ArrayList<String>();
		if(log.isDebugEnabled()) {
			log.debug("Entering listAll");
		}
		cities = mapService.getAllCities();
		
		if(log.isDebugEnabled()) {
			log.debug("Exiting listAll");
		}
		return cities;
	}

	
	/**
	 * Rest end-point which returns a boolean value whether the origin and the destination
	 * cities are connected.  
	 *
	 * @param origin
	 * @param destination
	 * @return boolean
	 */
	@RequestMapping(value = "/connected", method = RequestMethod.GET)
	public ResponseEntity<String> isConnected(@RequestParam(name = "origin") String origin, @RequestParam(name = "destination") String destination) {
		if(log.isDebugEnabled()) {
			log.debug("Entering isConnected");
		}
		boolean isConnected = false;
		if(!StringUtils.isEmpty(origin) && !StringUtils.isEmpty(destination)) {
			isConnected = mapService.isConnected(origin, destination);
		}
		else {
			log.error("Invalid input params!");
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		if(log.isDebugEnabled()) {
			log.debug("Exiting isConnected");
		}
		return new ResponseEntity<String>(String.valueOf(isConnected), HttpStatus.OK);
	}

}