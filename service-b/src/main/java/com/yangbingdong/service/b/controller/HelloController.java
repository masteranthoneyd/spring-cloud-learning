package com.yangbingdong.service.b.controller;

import com.yangbingdong.service.b.rpc.HelloRemoteClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ybd
 * @date 18-8-8
 * @contact yangbingdong1994@gmail.com
 */
@RestController
@RequestMapping("/service-b")
public class HelloController {

	@Resource
	private HelloRemoteClient helloClient;

	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {
		name += "!";
		return helloClient.sayHello(name);
	}
}
