# Uploadimage_intodbMvc
server.port=1002
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url= jdbc:mysql://localhost:3307/servicename
spring.datasource.username = 
spring.datasource.password = 
spring.jpa.show-sql= true
spring.jpa.hibernate.ddl-auto=update
## Allows Hibernate to generate SQL optimized for a particular DBMS
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect




#Data Base Configurtion
spring.datasource.url= jdbc:mysql://localhost:3307/cspworld
spring.datasource.username=
spring.datasource.password=root
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
spring.jpa.show-sql: true
spring.jpa.hibernate.ddl-auto=update
server.port=1001


#######################
package com.jkas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import com.jkas.entity.AgencyFeedBack;
import com.jkas.entity.AgencyMakulmBalas;
import com.jkas.service.AgencyMakulmBalasServiceI;
import com.jkas.util.ResponseUtily;

/*
 * RestController Class for post and get agency data
 * @author cp
 * */

@RestController
public class AgencyMakulmBalasResource {

	private static final Logger logger = LoggerFactory.getLogger(AgencyMakulmBalasResource.class);

	@Autowired
	private AgencyMakulmBalasServiceI agencyService;

	/*
	 * Rest call Method for Register Agency data
	 */

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> saveAgencyDetails(@RequestBody AgencyMakulmBalas agencyMakulmBalasEntity,
			AgencyFeedBack agencyNewFeedBack) {
		logger.debug("=====Inside saveAgencyDetails()===");
		logger.debug(agencyMakulmBalasEntity.toString());

		AgencyMakulmBalas responseData = agencyService.saveAgencydata(agencyMakulmBalasEntity);

		return ResponseUtily.generateSuccessResponse(responseData);

	}

	/*
	 * Rest call Method for fetch all Agency data
	 */

	@GetMapping(path = "/fetch", produces = "application/json")
	public ResponseEntity<Object> fetchAllAgencyDetails() {
		logger.debug("======inside fetchAllAgencyDetails========");
		List<AgencyMakulmBalas> list = agencyService.getAllAgencydata();
		return ResponseUtily.generateSuccessResponse(list);

	}

	/*
	 * Rest call Method for find Agency data by id
	 */

	@GetMapping(path = "/find/{notisPemberitahuan}", produces = "application/json")
	public ResponseEntity<Object> fetchAgencyDetails(@PathVariable String notisPemberitahuan) {
		logger.debug("==========inside fetchAgencyDetails============Agency id " + notisPemberitahuan);
		AgencyMakulmBalas agency = agencyService.getAgencydetailById(notisPemberitahuan);
		if (agency != null) {
			return ResponseUtily.generateSuccessResponse(agency);
		}
		return ResponseUtily.generateFailuerResponse(null);
	}

}
