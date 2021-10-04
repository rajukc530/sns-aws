package com.springboot.sns.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {

    @JsonProperty("subject")
    @NonNull
    final String subject;
    
    @JsonProperty("message")
    final String message;
}
