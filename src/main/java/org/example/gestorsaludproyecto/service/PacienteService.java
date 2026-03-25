package org.example.gestorsaludproyecto.service;

import org.example.gestorsaludproyecto.model.Paciente;
import org.example.gestorsaludproyecto.repository.PacienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class PacienteService {

    private final PacienteDAO pacienteDAO;

    @Autowired

    public PacienteService(@Qualifier("PacienteDAOJdbc") PacienteDAO pacienteDAO){this.pacienteDAO = pacienteDAO;}

    public void guardarPaciente(Paciente paciente) {pacienteDAO.guardar(paciente);}




}
