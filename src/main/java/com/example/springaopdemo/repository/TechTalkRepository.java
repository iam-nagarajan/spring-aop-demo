package com.example.springaopdemo.repository;

import com.example.springaopdemo.model.TechTalk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TechTalkRepository extends MongoRepository<TechTalk, String> {
}
