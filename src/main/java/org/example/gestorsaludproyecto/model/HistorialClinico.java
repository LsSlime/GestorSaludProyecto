package org.example.gestorsaludproyecto.model;

import javax.print.Doc;
import java.time.LocalDate;

public class HistorialClinico {

    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private Citas cita;
    private LocalDate fecha_registro;
    private String diagnostico, tratamiento, descripcion;


    public HistorialClinico() {
    }

    public HistorialClinico(int id, Paciente paciente, Doctor doctor, Citas cita, LocalDate fecha_registro, String diagnostico, String tratamiento, String descripcion) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
        this.cita = cita;
        this.fecha_registro = fecha_registro;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
