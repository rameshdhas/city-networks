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
import java.util.HashSet;
import java.util.Set;

/**
 * Java bean to hold the city information and its neighbors. 
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */
public class City implements Serializable{
	
	private static final long serialVersionUID = 1972960711641432890L;

	private String name;
	
	private boolean visited;
	
	private Set<City> neighbors = new HashSet<City>();

	public City(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public Set<City> getNeighbors() {
		return neighbors;
	}

	/**
	 * 
	 * @param neighbors
	 */
	public void setNeighbors(Set<City> neighbors) {
		this.neighbors = neighbors;
	}
	
	/**
	 * 
	 * @param city
	 */
	public void addNeighbor(City city) {
		this.neighbors.add(city);
	}
	
	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public int hashCode() {
		return ((name == null || "".equals(name.trim())) ? 0 : name.trim().hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		City other = (City) obj;
		if (this.name == null) {
			if (other.getName() != null)
				return false;
		} 
		else if(!this.name.trim().equals(other.getName().trim())) {
			return false;
		}
		return true;
	}

}
