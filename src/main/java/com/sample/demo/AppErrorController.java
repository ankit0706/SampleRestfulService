package com.sample.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppErrorController implements ErrorController{
		 
	@RequestMapping("/error")
	@ResponseBody 
	public String handlerError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	    Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
	    
		return "Bad Request. Kindly check the request format and send the request again."
				+ " statusCode = " + statusCode
				+ " error = " +  exception;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
