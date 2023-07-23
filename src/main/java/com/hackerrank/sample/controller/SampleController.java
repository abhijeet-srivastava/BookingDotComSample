package com.hackerrank.sample.controller;

import com.hackerrank.sample.service.MessagingService;
import com.hackerrank.sample.service.exception.MessageNotFoundException;
import com.hackerrank.sample.service.pojo.EchoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SampleController {
    @Autowired
    private MessagingService messagingService;

    @GetMapping(value = "defaultHello")
    public EchoMessage defaultHello(@RequestParam(name = "message", defaultValue = "World!") String message) {
        return this.messagingService.helloMessage(message);
    }

    @PostMapping(value = "customHello")
    public EchoMessage customMessage(@RequestParam(name = "message") String message) {
        try {
            return this.messagingService.customMessage(message);
        } catch (MessageNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", ex);
        }
    }
}
