package com.hackerrank.sample.service;

import com.hackerrank.sample.service.exception.MessageNotFoundException;
import com.hackerrank.sample.service.pojo.EchoMessage;

public interface MessagingService {
    EchoMessage helloMessage(String message);

    EchoMessage customMessage(String message) throws MessageNotFoundException;
}
