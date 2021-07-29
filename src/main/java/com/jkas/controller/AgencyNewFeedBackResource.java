package com.jkas.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import com.jkas.demo.FileUploadUtil;
import com.jkas.entity.AgencyNewFeedBack;
import com.jkas.repo.AgencyNewfeedBackRepo;
import com.jkas.service.AgencyNewFeedBackServiceI;

@Controller
public class AgencyNewFeedBackResource {

	@Autowired
	private AgencyNewFeedBackServiceI agencyNewFeedBackServiceI;
	@Autowired
	private AgencyNewfeedBackRepo agencyNewfeedBackRepo;

	private static final Logger logger = LoggerFactory.getLogger(AgencyNewFeedBackResource.class);

	@RequestMapping("show")
	public String show(Model model) {
		return "message";
	}

	@PostMapping(value = "/send")
	public String saveAgencyNewFeedBackDetails(@ModelAttribute AgencyNewFeedBack agencyNewFeedBack,@RequestParam("aftPicture") MultipartFile multipartFile1,
    @RequestParam("befPicture") MultipartFile multipartFile2) throws IOException {
		
		logger.debug("=====Inside saveAgencyNewFeedBackDetails()===");

		String AfterPicture = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
		String BeforePicture = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
	    
		
		
		String url1 = "image/" + AfterPicture;
		String url2 = "image/" + BeforePicture;
		
		FileOutputStream out = new FileOutputStream(url1);
		out.write(multipartFile1.getBytes()); 
		out.close();
		FileOutputStream out1 =new FileOutputStream(url2);
		out1.write(multipartFile2.getBytes()); 
		out1.close();
		agencyNewFeedBack.setBeforePicture(url2);
		agencyNewFeedBack.setAfterPicture(url1);
	
		if(agencyNewFeedBack.getOrganization().equals("Alam Flora Sdn Bhd")) {
			
			agencyNewFeedBack.setOrganization("Alam Flora Sdn Bhd");
		}
		else {
			agencyNewFeedBack.setOrganization("Jabatan Kesihatan & Alam Sekitar");
		}
		
		
		AgencyNewFeedBack agencyFeedback = agencyNewFeedBackServiceI.saveAgencyFeedBackForm(agencyNewFeedBack);


		
		return "redirect:show";

	}
	
	@GetMapping("/findall")
	public String findAllNewFeedBack(Model model) {
		
		List<AgencyNewFeedBack> listofFeedback=	agencyNewfeedBackRepo.findAll();
		
		model.addAttribute("findfeedback", listofFeedback);
		System.out.println(listofFeedback.toString());
		
		return "showfeedback";
		
	}

	

}

