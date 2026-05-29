package pacientes.salud.elian.services;

import java.util.List;

import pacientes.salud.elian.dto.PacienteDTO;

public interface PacienteService {

    PacienteDTO createPaciente(PacienteDTO pacienteDto);

    PacienteDTO getPacienteById(Long pacienteId);

    PacienteDTO getPacienteByCurp(String curp);

    List<PacienteDTO> getPacientesActivos();

    PacienteDTO updatePaciente(Long pacienteId, PacienteDTO updatePaciente);

    void darDeBajaPaciente(Long pacienteId);
}
