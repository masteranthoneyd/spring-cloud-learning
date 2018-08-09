package com.yangbingdong.service.a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author ybd
 * @date 18-8-8
 * @contact yangbingdong1994@gmail.com
 */
@RestController
@RequestMapping("/service-a")
public class HelloController {

	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name) throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		return localHost + ":  Hello 『" + name + "』  , Date: " + new Date();
	}
}
