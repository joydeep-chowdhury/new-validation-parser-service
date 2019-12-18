package com.wipro.holmes.uhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.holmes.uhg.model.GenericResponseModel;
import com.wipro.holmes.uhg.service.GSFParserService;

@RestController
public class NewValidationController 
     {
	    @Autowired
        private GSFParserService gps;
	    @RequestMapping(value="/parser",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	    public ResponseEntity<GenericResponseModel> parser()
	    {
	    	GenericResponseModel rm=gps.parse();
	    	return new ResponseEntity<>(rm,HttpStatus.OK);
	    	
	    }
     }
