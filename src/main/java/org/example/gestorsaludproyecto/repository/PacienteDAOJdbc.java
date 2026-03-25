package org.example.gestorsaludproyecto.repository;


import org.example.gestorsaludproyecto.model.Paciente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("PacienteDAOJdbc")
public class PacienteDAOJdbc implements PacienteDAO {

    private Connection getConnection() {
        return Conexion.getInstancia().getConnection();
    }


    @Override
    public void guardar(Paciente paciente) {
        String sql = "INSERT INTO pacientes (dni, nombre, apellido1, apellido2, fechaNacimiento, genero, telefono, email, direccion) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, paciente.getDni());
            pstmt.setString(2, paciente.getNombre());
            pstmt.setString(3, paciente.getApellido1());
            pstmt.setString(4, paciente.getApellido2());
            pstmt.setDate(5, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
            pstmt.setString(6, paciente.getGenero());
            pstmt.setInt(7, paciente.getTelefono());
            pstmt.setString(8, paciente.getEmail());
            pstmt.setString(9, paciente.getDireccion());
            pstmt.executeUpdate();
            System.out.println(" ✅ Paciente guardado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al querer guardar el paciente.");
            e.printStackTrace();

        }


    }

    @Override
    public void actualizar(Paciente paciente) {
        String sql = "UPDATE paciente set nombre = ?, apellido1 = ?, apellido2 = ?, fechaNacimiento = ?, telefono = ?, email = ?, direccion = ? where id = ?";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellido1());
            pstmt.setString(3, paciente.getApellido2());
            pstmt.setDate(4, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
            pstmt.setInt(5, paciente.getTelefono());
            pstmt.setString(6, paciente.getEmail());
            pstmt.setString(7, paciente.getDireccion());
            pstmt.executeUpdate();
            System.out.println(" ✅ Paciente actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al querer actualizar el paciente.");
            e.printStackTrace();

        }

    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" ✅ Paciente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al querer eliminar el paciente.");
            e.printStackTrace();

        }

    }

    @Override
    public Paciente obtenerPorId(int id){
        String sql = "SELECT * FROM paciente WHERE id = ?";
        Paciente paciente = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next()) {
                    paciente = mapearPaciente(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al querer obtener el paciente por ID.");
            e.printStackTrace();
        }
        return paciente;
    }

   @Override
           public List<Paciente> listarTodos() {
            List<Paciente> pacientes = new ArrayList<>();
            String sql = "SELECT * FROM paciente";
            try (PreparedStatement pstmt = getConnection().prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    pacientes.add(mapearPaciente(rs))
                }
                System.out.println("Listado de pacientes recuperado correctamente.");
            }catch (SQLException e) {
                System.out.println("Error al querer listar los pacientes.");
                e.printStackTrace();
            }
            return pacientes;
        }

        private Paciente mapearPaciente(ResultSet rs) throws SQLException {

                    Paciente paciente = new Paciente();
                    paciente.setId(rs.getInt("id"));
                    paciente.setDni(rs.getString("dni"));
                    paciente.setNombre(rs.getString("nombre"));
                    paciente.setApellido1(rs.getString("apellido1"));
                    paciente.setApellido2(rs.getString("apellido2"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    paciente.setGenero(rs.getString("genero"));
                    paciente.setTelefono(rs.getInt("telefono"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setDireccion(rs.getString("direccion"));
                    return paciente;
        }

}