package sn.supdeco.gestion_academique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supdeco.gestion_academique.entity.Note;
import sn.supdeco.gestion_academique.service.InscriptionService;
import sn.supdeco.gestion_academique.service.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;
    
    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.findAll());
        return "note/liste";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("inscriptions", inscriptionService.findAll());
        return "note/form";
    }

    @PostMapping("/enregistrer")
    public String saveNote(@ModelAttribute Note note) {
        noteService.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Note note = noteService.findById(id);
        if (note != null) {
            model.addAttribute("note", note);
            model.addAttribute("inscriptions", inscriptionService.findAll());
            return "note/form";
        }
        return "redirect:/notes";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
        return "redirect:/notes";
    }
}
