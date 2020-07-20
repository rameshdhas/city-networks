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
package com.connection.map.models;

import java.io.Serializable;

import com.connection.map.constants.Mode;

/**
 * Java bean to hold the connection info between two cities.
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */
public class Connection implements Serializable{
	
	private static final long serialVersionUID = -2385027490039858672L;

	private City origin;
	
	private City destination;
	
	private Mode mode;
	
	private int distance;

	public Connection(City origin, City destination, Mode mode, int distance) {
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
		this.mode = mode;
	}
	
	/**
	 * 
	 * @return
	 */
	public City getOrigin() {
		return origin;
	}

	/**
	 * 
	 * @param origin
	 */
	public void setOrigin(City origin) {
		this.origin = origin;
	}

	/**
	 * 
	 * @return
	 */
	public City getDestination() {
		return destination;
	}

	/**
	 * 
	 * @param destination
	 */
	public void setDestination(City destination) {
		this.destination = destination;
	}

	/**
	 * 
	 * @return
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * 
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * 
	 * @return
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * 
	 * @param mode
	 */
	public void setMode(Mode mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return origin + " to " + destination + " : " + distance;
	}

}