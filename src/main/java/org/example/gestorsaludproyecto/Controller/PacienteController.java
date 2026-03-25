package org.example.gestorsaludproyecto.Controller;


import org.example.gestorsaludproyecto.model.Paciente;
import org.example.gestorsaludproyecto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteController {

    private final PacienteService pacienteService;


    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }


    @GetMapping("/pacientes")
    public String listarPacientes(Model model){
        model.addAttribute("pacientes", pacienteService.listarTodosLosPacientes());
        return "Menu_Crear_Paciente";
    }

    @GetMapping("/pacientes/nuevo")
    public String mostrarFormulario(Model model){
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        return "Formulario_Crear_Paciente";
    }


    @GetMapping("/pacientes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model){
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente == null) {
            return "redirect:/pacientes";
        }
        model.addAttribute("paciente", paciente);
        return "Formulario_Editar_Paciente";
    }


    @PostMapping("/pacientes/eliminar/{id}")
    public String eliminarPaciente(@PathVariable int id){
        Paciente existente = pacienteService.buscarPacientePorId(id);
        pacienteService.eliminarPaciente(id);
        return "redirect:/pacientes";
    }

}
