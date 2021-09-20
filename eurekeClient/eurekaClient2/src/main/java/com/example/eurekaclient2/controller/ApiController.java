package com.example.eurekaclient2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("api")
public class ApiController {


    @GetMapping("/{param}")
    public ResponseEntity<String> handleRequestFromClient1(@PathVariable("param") String fictiveParameter) {
        System.out.println(MessageFormat.format("Request from Client 1 with param {0}",fictiveParameter));
        return ResponseEntity.ok(fictiveParameter.concat("@@@@@@"));
    }


}
