package org.example.gestorsaludproyecto.service;

import org.example.gestorsaludproyecto.model.Paciente;
import org.example.gestorsaludproyecto.repository.PacienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService {

    private final PacienteDAO pacienteDAO;

    @Autowired

    public PacienteService(@Qualifier("PacienteDAOJdbc") PacienteDAO pacienteDAO){this.pacienteDAO = pacienteDAO;}

    public void guardarPaciente(Paciente paciente) {pacienteDAO.guardar(paciente);}

    public void actualizarPaciente(Paciente paciente) {pacienteDAO.actualizar(paciente);}

    public void eliminarPaciente(Paciente paciente) {pacienteDAO.eliminar(paciente);}

    public Paciente buscarPacientePorId(Integer id) {pacienteDAO.obtenerPorId(id);}

    public List<Paciente> listarTodosLosPacientes() {pacienteDAO.listarTodos();}


}
