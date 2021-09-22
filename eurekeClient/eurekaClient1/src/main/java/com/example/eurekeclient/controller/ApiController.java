package com.example.eurekeclient.controller;

import com.example.eurekeclient.feign.ApiClient;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ApiController {


    private LoadBalancerClient loadBalancerClient;
    private ApiClient apiClient;

    @PostMapping("/rest")
    public ResponseEntity<String> sendRequestToClient2(@RequestParam String param) {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKACLIENT2");
        String response = restTemplate.getForObject(MessageFormat.format("{0}/api/{1}", serviceInstance.getUri().toString(), param), String.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/feign")
    public ResponseEntity<String> sendRequestToClient2WithFeign(@RequestParam String param) {
        return apiClient.sendRequestToClient2(param);
    }
}
