package com.springboot.sns.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.springboot.sns.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SnsController {

    // Topic arn. Developers are free to choose their own topic arn.
    private static final String TOPIC = "arn:aws:sns:us-east-2:474413509249:raju-test";

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    // URL - http://localhost:8080/addSubscription/myemail@somecompany.com
    @PostMapping(value = "/addSubscription/{email}")
    public ResponseEntity<String> addSubscription(@PathVariable final String email) {
        log.info("Adding new email subscription = {} to the topic.", email);
        final SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC, "email", email);
        amazonSNSClient.subscribe(subscribeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // URL - http://localhost:8080/sendNotification
    // Sample request body -
    //	{
    //		"subject": "Springboot sns demo email",
    //		"message": "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
    //	}
    @PostMapping(value = "/sendNotification")
    public ResponseEntity<String> publishMessageToTopic(@RequestBody final Notification notification) {
        log.info("Publishing the notification = {} to the topic.", notification.toString());
        final PublishRequest publishRequest = new PublishRequest(TOPIC, notification.getMessage(), notification.getSubject());
        amazonSNSClient.publish(publishRequest);
        return new ResponseEntity<>("Notification sent successfully!!", HttpStatus.OK);
    }
}
