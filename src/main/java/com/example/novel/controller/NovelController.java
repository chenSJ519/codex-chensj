package com.example.novel.controller;

import com.example.novel.model.Novel;
import com.example.novel.service.NovelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/novels")
public class NovelController {
    private final NovelService service;

    public NovelController(NovelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Novel> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Novel> byId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Novel create(@RequestBody Novel novel) {
        return service.save(novel);
    }
}
