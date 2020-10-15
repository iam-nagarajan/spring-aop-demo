package com.example.springaopdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "techtalk")
public class TechTalk {
    @Id
    private String id;
    private String presenter;
    private String topic;
    private String recordingLink;
    private String date;
}
