package com.jkas.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.jkas.entity.AgencyNewFeedBack;

@Repository
public interface AgencyNewfeedBackRepo extends JpaRepository<AgencyNewFeedBack, Integer> {

	
	
}
