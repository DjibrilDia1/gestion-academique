package sn.supdeco.gestion_academique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supdeco.gestion_academique.entity.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
