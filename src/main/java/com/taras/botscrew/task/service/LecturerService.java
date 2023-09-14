package com.taras.botscrew.task.service;

import com.taras.botscrew.task.domain.Lecturer;
import com.taras.botscrew.task.repositories.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {
    private final LecturerRepository lecturerRepository;

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public List<Lecturer> globalSearchByTemplate(String searchTemplate) {
        return lecturerRepository.findByFullNameContainingIgnoreCase(searchTemplate);
    }
}
