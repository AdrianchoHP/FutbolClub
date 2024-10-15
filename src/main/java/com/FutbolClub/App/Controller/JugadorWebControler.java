package com.FutbolClub.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FutbolClub.App.Entity.Clubes;
import com.FutbolClub.App.Entity.Jugadores;
import com.FutbolClub.App.Exception.NotFoundException;
import com.FutbolClub.App.Repositorio.JugadorRepository;
import com.FutbolClub.App.Repositorio.ClubRepository; // Importar el repositorio de Clubes

@Controller
@RequestMapping(value = "jugadores")
public class JugadorWebControler {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private ClubRepository clubRepository; // Inyección del ClubRepository

    @GetMapping("")
    public String jugadoresListTemplate(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugadores-list";
    }

    @GetMapping("/new")
    public String jugadoresNewTemplate(Model model) {
        model.addAttribute("jugadores", new Jugadores());
        model.addAttribute("clubesList", clubRepository.findAll()); // Obtener la lista de clubes
        return "jugadores-form";
    }

    @GetMapping("/edit/{id}")
    public String jugadoresEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("jugadores", jugadorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("jugador no encontrado")));
        model.addAttribute("clubesList", clubRepository.findAll()); // Obtener la lista de clubes para el formulario de edición
        return "jugadores-edit";
    }

    @PostMapping("/save")
    public String jugadoresSaveProcess(@ModelAttribute("jugadores") Jugadores jugadores, Model model) {
        if (jugadorRepository.existsByNombre(jugadores.getNombre())) {
            model.addAttribute("errorMessage", "El jugador ya existe.");
            return "jugadores-form";
        }

        if (jugadores.getId() == null || jugadores.getId().isEmpty()) {
            jugadores.setId(null);
        }

        // Asegúrate de asignar el club correspondiente
        if (jugadores.getClub() != null) {
            Clubes club = clubRepository.findById(jugadores.getClub().getId())
                .orElseThrow(() -> new NotFoundException("Club no encontrado"));
            jugadores.setClub(club);
        }

        jugadorRepository.save(jugadores);
        return "redirect:/jugadores";
    }

    @PostMapping("/save/edit")
    public String jugadoresSaveeditProcess(@ModelAttribute("jugadores") Jugadores jugadores, Model model) {
        if (jugadores.getId() == null || jugadores.getId().isEmpty()) {
            jugadores.setId(null);
        }

        // Asegúrate de asignar el club correspondiente al editar
        if (jugadores.getClub() != null) {
            Clubes club = clubRepository.findById(jugadores.getClub().getId())
                .orElseThrow(() -> new NotFoundException("Club no encontrado"));
            jugadores.setClub(club);
        }

        jugadorRepository.save(jugadores);
        return "redirect:/jugadores";
    }
    
    @GetMapping("/delete/{id}")
    public String jugadoresDeleteProcess(@PathVariable("id") String id) {
    	jugadorRepository.deleteById(id);
        return "redirect:/jugadores";
    }

}
