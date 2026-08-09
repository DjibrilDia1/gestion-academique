package sn.supdeco.gestion_academique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supdeco.gestion_academique.entity.Note;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByInscriptionId(Long inscriptionId);
}
