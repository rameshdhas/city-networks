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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.connection.map.config.ApplicationConfig;

/**
 * JUnit test cases class that can be used to test the Spring application.
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = { ApplicationConfig.class })
public class MapServiceTest {

	@Autowired
	private MapService mapService;

	@Test
	public void testLoadData() {
		mapService.loadData();
	}

	@Test
	public void testIsConnectedNull() {
		boolean isConnected = mapService.isConnected(null, null);
		assertFalse(isConnected);
	}

	@Test
	public void testIsConnectedBlank() {
		boolean isConnected = mapService.isConnected("", "");
		assertFalse(isConnected);
	}

	@Test
	public void testConnected() {
		boolean isConnected = mapService.isConnected("Boston", "New York");
		assertTrue(isConnected);
	}
	
	@Test
	public void testNotConnected() {
		boolean isConnected = mapService.isConnected("Philadelphia", "Albany");
		assertFalse(isConnected);
	}
	
	@Test
	public void testConnectedWithSpaces() {
		boolean isConnected = mapService.isConnected("Boston   ", "    New York");
		assertTrue(isConnected);
	}
	
	@Test
	public void testNotConnectedWithSpaces() {
		boolean isConnected = mapService.isConnected("  Philadelphia", "Albany  ");
		assertFalse(isConnected);
	}
	
	@Test
	public void testConnectedWithCaseSensitive() {
		boolean isConnected = mapService.isConnected("boston", "new york");
		assertTrue(isConnected);
	}
}
