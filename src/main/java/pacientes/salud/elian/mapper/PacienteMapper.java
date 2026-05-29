package pacientes.salud.elian.mapper;

import pacientes.salud.elian.dto.PacienteDTO;
import pacientes.salud.elian.entity.Paciente;

public class PacienteMapper {

    public static PacienteDTO mapToPacienteDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();

        dto.setIdPaciente(paciente.getIdPaciente());
        dto.setNombre(paciente.getNombre());
        dto.setApellidos(paciente.getApellidos());
        dto.setCurp(paciente.getCurp());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setTipoSangre(paciente.getTipoSangre());
        dto.setTelefono(paciente.getTelefono());
        dto.setEmail(paciente.getEmail());
        dto.setActivo(paciente.getActivo());

        return dto;
    }

    public static Paciente mapToPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setIdPaciente(pacienteDTO.getIdPaciente());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellidos(pacienteDTO.getApellidos());
        paciente.setCurp(pacienteDTO.getCurp());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setTipoSangre(pacienteDTO.getTipoSangre());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setActivo(pacienteDTO.getActivo());

        return paciente;
    }
}
