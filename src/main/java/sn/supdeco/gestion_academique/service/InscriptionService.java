package sn.supdeco.gestion_academique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supdeco.gestion_academique.entity.Inscription;
import sn.supdeco.gestion_academique.repository.InscriptionRepository;
import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    public Inscription findById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    public List<Inscription> findByEtudiant(Long etudiantId) {
        return inscriptionRepository.findByEtudiantId(etudiantId);
    }

    public List<Inscription> findByCours(Long coursId) {
        return inscriptionRepository.findByCoursId(coursId);
    }

    public Inscription save(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public void deleteById(Long id) {
        inscriptionRepository.deleteById(id);
    }
}
