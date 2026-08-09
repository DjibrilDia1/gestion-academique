package sn.supdeco.gestion_academique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supdeco.gestion_academique.entity.Etudiant;
import sn.supdeco.gestion_academique.repository.EtudiantRepository;
import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    public Etudiant findById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public void deleteById(Long id) {
        etudiantRepository.deleteById(id);
    }
}
