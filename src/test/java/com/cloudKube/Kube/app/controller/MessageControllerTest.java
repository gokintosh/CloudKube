package com.cloudKube.Kube.app.controller;

import com.cloudKube.Kube.app.model.MessageResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@AutoConfigureMockMvc
public class MessageControllerTest{

    @LocalServerPort
    int randomServerPort;

    @Test
    void testAddCustomerSuccess() throws URISyntaxException, JsonProcessingException{
        RestTemplate restTemplate=new RestTemplate();
        String baseUrl="http://localhost:"+randomServerPort+"/sayhello";

        URI url=new URI(baseUrl);

        HttpHeaders headers=new HttpHeaders();

        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);


        ResponseEntity<MessageResponse> responseResponseEntity=restTemplate.getForEntity(url, MessageResponse.class);

        assertEquals("200 OK",responseResponseEntity.getStatusCode().toString());
        MessageResponse response=responseResponseEntity.getBody();

        assertEquals("Hello from Random Application!!",response.getMessage());

    }



}