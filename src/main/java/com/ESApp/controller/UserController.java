package com.ESApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ESApp.constant.EResponse;
import com.ESApp.service.UserService;
import com.ESApp.utility.BaseResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public ResponseEntity<BaseResponse> expense(@RequestBody String input) {
		log.info("Inside expense()");
		BaseResponse response = new BaseResponse();
		try {
			List<String> output = userService.transations(input);
			response.setResponseCode(EResponse.SUCCESS.getCode());
			response.setResponseMessage(EResponse.SUCCESS.getMessage());
			response.setResponseBody(output);
		} catch (Exception e) {
			response.setResponseCode(EResponse.FAILED.getCode());
			response.setResponseMessage(EResponse.FAILED.getMessage());
			response.setResponseBody(e.getMessage());

		}
		log.info("Exit expense()");
		return ResponseEntity.ok(response);
	}
	@GetMapping("/showbalance")
	public ResponseEntity<BaseResponse> showBalances() {
		log.info("Inside expense()");
		BaseResponse response = new BaseResponse();
		try {
			List<String> output = userService.showBalances();
			response.setResponseCode(EResponse.SUCCESS.getCode());
			response.setResponseMessage(EResponse.SUCCESS.getMessage());
			response.setResponseBody(output);
		} catch (Exception e) {
			response.setResponseCode(EResponse.FAILED.getCode());
			response.setResponseMessage(EResponse.FAILED.getMessage());
			response.setResponseBody(e.getMessage());

		}
		log.info("Exit expense()");
		return ResponseEntity.ok(response);
	}
}
