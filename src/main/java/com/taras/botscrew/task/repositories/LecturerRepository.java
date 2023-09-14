package com.taras.botscrew.task.repositories;

import com.taras.botscrew.task.domain.Lecturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LecturerRepository extends CrudRepository<Lecturer, Long> {

    List<Lecturer> findByFullNameContainingIgnoreCase(String searchTemplate);
}
