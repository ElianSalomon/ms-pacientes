package pacientes.salud.elian.services;

import java.util.List;

import pacientes.salud.elian.dto.PacienteDTO;

public interface PacienteService {

    PacienteDTO createPaciente(PacienteDTO pacienteDto);

    PacienteDTO getPacienteById(Long pacienteId);

    List<PacienteDTO> getAllPacientes();

    PacienteDTO updatePaciente(Long pacienteId, PacienteDTO updatePaciente);

    void deletePaciente(Long pacienteId);

    PacienteDTO getPacienteByCorreo(String correo);
}
