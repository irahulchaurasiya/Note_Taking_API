package com.skillStreet.Note_Taking.controller;

import com.skillStreet.Note_Taking.model.Note;
import com.skillStreet.Note_Taking.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createOrUpdateNote(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        Optional<Note> existingNote = noteService.getNoteById(id);

        if (existingNote.isPresent()) {
            updatedNote.setId(id);
            return ResponseEntity.ok(noteService.createOrUpdateNote(updatedNote));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        Optional<Note> existingNote = noteService.getNoteById(id);

        if (existingNote.isPresent()) {
            noteService.deleteNoteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
