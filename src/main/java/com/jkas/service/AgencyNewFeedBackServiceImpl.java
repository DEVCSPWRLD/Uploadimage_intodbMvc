package com.jkas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkas.entity.AgencyNewFeedBack;
import com.jkas.repo.AgencyNewfeedBackRepo;

@Service
public class AgencyNewFeedBackServiceImpl implements AgencyNewFeedBackServiceI {

	private static final Logger logger =LoggerFactory.getLogger(AgencyNewFeedBackServiceImpl.class);
	
	@Autowired
	private AgencyNewfeedBackRepo agencyFeedBackRepo;
	
	@Override
	public AgencyNewFeedBack saveAgencyFeedBackForm(AgencyNewFeedBack agencyNewFeedBack) {
		 logger.debug("===========INSIDE saveAgencyFeedBackForm  =============");
			return agencyFeedBackRepo.save(agencyNewFeedBack);
	}

}
