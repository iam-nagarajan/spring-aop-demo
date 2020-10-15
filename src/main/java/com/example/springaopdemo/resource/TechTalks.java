package com.example.springaopdemo.resource;

import com.example.springaopdemo.aspect.Log;
import com.example.springaopdemo.model.TechTalk;
import com.example.springaopdemo.repository.TechTalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tech-talks")
public class TechTalks {
    private final TechTalkRepository techTalkRepository;

    @GetMapping("/{id}")
    @Log
    public ResponseEntity<TechTalk> get(@PathVariable("id") String id) {
        return techTalkRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Log
    public ResponseEntity<Serializable> save(@RequestBody TechTalk techTalk) {
            techTalkRepository.save(techTalk);
        return ResponseEntity.accepted().build();
    }
}
