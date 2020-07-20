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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.connection.map.constants.Mode;
import com.connection.map.models.City;
import com.connection.map.models.Connection;

/**
 * Service class that contains all the service methods for city connections API.
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */

@Service
public class MapService {
	
	private Logger log = LoggerFactory.getLogger(MapService.class);
	
	private List<City> cities = new ArrayList<City>();
	
	private List<Connection> connections = new ArrayList<Connection>();

	private Map<String, Set<String>> highwayMap = new HashMap<String, Set<String>>();

	public void addCity(City city) {
		this.cities.add(city);
	}
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @param distance
	 */
	public void connect(City source, City destination, Mode mode, int distance) {
		Connection connection = new Connection(source, destination, mode, distance);
		source.addNeighbor(destination);
		this.connections.add(connection);
	}
	
	
	/**
	 * @param source
	 * @param destination
	 * @return
	 */
	public int getDistance(City origin, City destination) {
		for (Connection connection : this.connections) {
			if (connection.getOrigin().equals(origin) && connection.getDestination().equals(destination)) {
				return connection.getDistance();
			}
		}
		return 0;
	}
	
	
	/**
	 * Breath first search algorithm to find out if two cities are connected.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean isConnected(String origin, String destination){
		if(log.isDebugEnabled()) {
			log.debug("Entering isConnected");
		}
		log.info("Input params : origin = "+ origin + ", destination = "+ destination);
		
		boolean isConnected = false;

        if(highwayMap.containsKey(origin) && highwayMap.containsKey(destination)){
            Set<String> citiesVisited = new HashSet<>();
            Queue<String> citiesToVisit = new LinkedList<>();
            citiesToVisit.add(origin);

            while (!citiesToVisit.isEmpty() && !isConnected) {
                String city = citiesToVisit.poll();
                isConnected = city.equals(destination);
                
                Set<String> neighbors = highwayMap.get(city);

                for (String neighbor : neighbors) {
                    if (!citiesVisited.contains(neighbor)) {
                        citiesToVisit.add(neighbor);
                        citiesVisited.add(neighbor);
                    }
                }
            }
        }
        log.info("isConnected : " + isConnected);
        
        if(log.isDebugEnabled()) {
			log.debug("Exiting isConnected");
		}
        return isConnected;
    }
	
	/**
	 * Returns a list of supported city names.
	 * 
	 * @return List<String>
	 */
	public List<String> getAllCities(){
		List<String> cities = new ArrayList<String>();
		if(log.isDebugEnabled()) {
			log.debug("Entering isConnected");
		}
		
		
		if(log.isDebugEnabled()) {
			log.debug("Exiting isConnected");
		}
		return cities;
	}
	
	
}
