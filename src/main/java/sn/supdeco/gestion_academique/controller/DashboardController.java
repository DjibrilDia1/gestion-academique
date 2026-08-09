package sn.supdeco.gestion_academique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sn.supdeco.gestion_academique.service.CoursService;
import sn.supdeco.gestion_academique.service.EtudiantService;
import sn.supdeco.gestion_academique.service.InscriptionService;

@Controller
public class DashboardController {

    @Autowired
    private EtudiantService etudiantService;
    
    @Autowired
    private CoursService coursService;
    
    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping({"/", "/tableau-de-bord"})
    public String dashboard(Model model) {
        model.addAttribute("totalEtudiants", etudiantService.findAll().size());
        model.addAttribute("totalCours", coursService.findAll().size());
        model.addAttribute("totalInscriptions", inscriptionService.findAll().size());
        return "dashboard/index";
    }
}
