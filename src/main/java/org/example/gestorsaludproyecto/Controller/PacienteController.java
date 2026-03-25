package org.example.gestorsaludproyecto.Controller;


import org.example.gestorsaludproyecto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PacienteController {

    private final PacienteService pacienteService;


    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

}
