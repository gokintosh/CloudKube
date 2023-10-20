package com.cloudKube.Kube.app.controller;


import com.cloudKube.Kube.app.model.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayhello")
public class MessageController {

    @GetMapping
    public MessageResponse getMessage(){
        return MessageResponse.builder().message("Hello from Random Application!!").build();
    }
}
