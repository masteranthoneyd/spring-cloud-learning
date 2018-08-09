package com.yangbingdong.service.b.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ybd
 * @date 18-8-8
 * @contact yangbingdong1994@gmail.com
 */
@FeignClient(value = "service-a", path = "/service-a")
public interface HelloRemoteClient {

	@GetMapping("/{name}")
	String sayHello(@PathVariable("name") String name);
}
