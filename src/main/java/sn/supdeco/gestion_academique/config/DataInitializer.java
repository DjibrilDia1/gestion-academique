package sn.supdeco.gestion_academique.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sn.supdeco.gestion_academique.entity.Utilisateur;
import sn.supdeco.gestion_academique.repository.UtilisateurRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (utilisateurRepository.findByUsername("admin").isEmpty()) {
            Utilisateur admin = new Utilisateur();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            utilisateurRepository.save(admin);
        }
        
        if (utilisateurRepository.findByUsername("enseignant").isEmpty()) {
            Utilisateur enseignant = new Utilisateur();
            enseignant.setUsername("enseignant");
            enseignant.setPassword(passwordEncoder.encode("prof123"));
            enseignant.setRole("ROLE_ENSEIGNANT");
            utilisateurRepository.save(enseignant);
        }
    }
}
