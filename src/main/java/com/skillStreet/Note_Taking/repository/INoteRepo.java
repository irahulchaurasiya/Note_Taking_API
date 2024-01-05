package com.skillStreet.Note_Taking.repository;

import com.skillStreet.Note_Taking.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepo extends JpaRepository<Note, Long> {
}
