package com.example.novel.service;

import com.example.novel.model.Novel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NovelService {
    private final Map<Long, Novel> novels = new HashMap<>();

    public NovelService() {
        // sample data
        save(new Novel(1L, "Spring in Action", "Craig Walls", "A book about Spring"));
        save(new Novel(2L, "Journey to the West", "Wu Cheng'en", "Classic Chinese novel"));
    }

    public List<Novel> findAll() {
        return new ArrayList<>(novels.values());
    }

    public Optional<Novel> findById(Long id) {
        return Optional.ofNullable(novels.get(id));
    }

    public Novel save(Novel novel) {
        if (novel.getId() == null) {
            novel.setId((long) (novels.size() + 1));
        }
        novels.put(novel.getId(), novel);
        return novel;
    }
}
