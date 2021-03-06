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
package com.connection.map.services;

import static com.connection.map.constants.MapConstants.COMMA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Service class that contains all the service methods for city connections API.
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */

@Service
public class MapService {

	private Logger log = LoggerFactory.getLogger(MapService.class);

	@Autowired
	private ResourceLoader resourceLoader;

	@Value("${data.file.path}")
	private String dataFile;

	private Map<String, Set<String>> connectionsMap = new HashMap<String, Set<String>>();

	/**
	 * Breath first search algorithm to find out if two cities are connected.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean isConnected(String origin, String destination) {
		if (log.isDebugEnabled()) {
			log.debug("Entering isConnected");
		}
		log.info("Input params : origin = " + origin + ", destination = " + destination);

		boolean isConnected = false;

		if (origin == null || destination == null) {
			return isConnected;
		}

		origin = origin.trim().toLowerCase();
		destination = destination.trim().toLowerCase();

		if (connectionsMap.containsKey(origin) && connectionsMap.containsKey(destination)) {
			Set<String> citiesVisited = new HashSet<>();
			Queue<String> citiesToVisit = new LinkedList<>();
			citiesToVisit.add(origin);

			while (!citiesToVisit.isEmpty() && !isConnected) {
				String city = citiesToVisit.poll();
				isConnected = city.equalsIgnoreCase(destination);

				Set<String> neighbors = connectionsMap.get(city);

				for (String neighbor : neighbors) {
					if (!citiesVisited.contains(neighbor)) {
						citiesToVisit.add(neighbor);
						citiesVisited.add(neighbor);
					}
				}
			}
		}
		log.info("isConnected : " + isConnected);

		if (log.isDebugEnabled()) {
			log.debug("Exiting isConnected");
		}
		return isConnected;
	}

	@PostConstruct
	public void loadData() {
		if (log.isDebugEnabled()) {
			log.debug("Entering loadData");
		}
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			log.info("Loading data from " + dataFile);
			Resource resource = resourceLoader.getResource("classpath:".concat(dataFile));
			inputStream = resource.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] cities = line.split(COMMA);
				String firstCity = cities[0].trim().toLowerCase();
				String secondCity = cities[1].trim().toLowerCase();

				if (!connectionsMap.containsKey(firstCity))
					connectionsMap.put(firstCity, new HashSet<String>());

				if (!connectionsMap.containsKey(secondCity))
					connectionsMap.put(secondCity, new HashSet<String>());

				connectionsMap.get(firstCity).add(secondCity);
				connectionsMap.get(secondCity).add(firstCity);
			}

			log.info("Total cities loaded : " + connectionsMap.size());
		} catch (Exception e) {
			log.error("Error in loading data : " + e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}

			} catch (IOException e) {
				log.error("Error in closing stream : " + e.getMessage());
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("Exiting loadData");
		}
	}

	/**
	 * Returns a set of supported city names.
	 * 
	 * @return Set<String>
	 */
	public Set<String> getAllCities() {
		Set<String> cities = new HashSet<String>();
		if (log.isDebugEnabled()) {
			log.debug("Entering isConnected");
		}
		if (connectionsMap.size() > 0) {
			cities = connectionsMap.keySet();
		}
		if (log.isDebugEnabled()) {
			log.debug("Exiting isConnected");
		}
		return cities;
	}

}
