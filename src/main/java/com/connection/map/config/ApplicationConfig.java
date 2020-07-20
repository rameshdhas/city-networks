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
package com.connection.map.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.connection.map.controllers.MapController;
import com.connection.map.services.MapService;

/**
 * Configuration Class that can be used configure the spring application, such
 * as component scan or import other needed spring beans and configurations.
 *
 * @author Ramesh Dhason
 * @since 1.0.0
 */

@Configuration
@Import({ SwaggerConfig.class, MapController.class, MapService.class })
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}
