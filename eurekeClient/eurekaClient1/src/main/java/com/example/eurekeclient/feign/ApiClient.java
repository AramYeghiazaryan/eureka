package com.example.eurekeclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("EUREKACLIENT2")
public interface ApiClient {
    @GetMapping("/api/{param}")
    ResponseEntity<String> sendRequestToClient2(@PathVariable("param") String param);
}
