package com.skillStreet.Note_Taking.service;

import com.skillStreet.Note_Taking.model.Note;
import com.skillStreet.Note_Taking.repository.INoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private INoteRepo noteRepo;

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepo.findById(id);
    }

    public Note createOrUpdateNote(Note note) {
        note.setCreationOrInundationTime(LocalDateTime.now());
        return noteRepo.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepo.deleteById(id);
    }
}
