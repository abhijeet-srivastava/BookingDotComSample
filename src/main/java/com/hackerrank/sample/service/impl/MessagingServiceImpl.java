package com.hackerrank.sample.service.impl;

import com.hackerrank.sample.service.MessagingService;
import com.hackerrank.sample.service.exception.MessageNotFoundException;
import com.hackerrank.sample.service.pojo.EchoMessage;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessagingServiceImpl implements MessagingService {
    private static final String DEFAULT_MESSAGE = "Hello World!";
    private static final String FINAL_MESSAGE = "Hello %s";

    @Override
    public EchoMessage helloMessage(String message) {
        return new EchoMessage.Builder()
                .setMessage(Objects.isNull(message) ? DEFAULT_MESSAGE : String.format(FINAL_MESSAGE, message))
                .buildMessage();
    }

    @Override
    public EchoMessage customMessage(String message) throws MessageNotFoundException {
        if(Objects.isNull(message)) {
            throw new MessageNotFoundException("Message not found");
        }
        return new EchoMessage.Builder()
                .setMessage(String.format(FINAL_MESSAGE, message))
                .buildMessage();
    }
}
