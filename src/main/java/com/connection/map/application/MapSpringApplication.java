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
package com.connection.map.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.connection.map.config.MapConfig;

/**
 * Class that can be used to bootstrap and launch a Spring application from a
 * Java main method.
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */
@SpringBootApplication
@Import({ MapConfig.class })
public class MapSpringApplication {

	/**
	 * Main method to start the spring boot application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MapSpringApplication.class, args);
	}

}
