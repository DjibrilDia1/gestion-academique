package sn.supdeco.gestion_academique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supdeco.gestion_academique.entity.Note;
import sn.supdeco.gestion_academique.repository.NoteRepository;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> findByInscription(Long inscriptionId) {
        return noteRepository.findByInscriptionId(inscriptionId);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public double calculerMoyennePourInscription(Long inscriptionId) {
        List<Note> notes = findByInscription(inscriptionId);
        if (notes == null || notes.isEmpty()) {
            return 0.0;
        }

        double totalValeur = 0.0;
        double totalCoefficient = 0.0;

        for (Note note : notes) {
            totalValeur += note.getValeur() * note.getCoefficient();
            totalCoefficient += note.getCoefficient();
        }

        return totalCoefficient > 0 ? totalValeur / totalCoefficient : 0.0;
    }
}
