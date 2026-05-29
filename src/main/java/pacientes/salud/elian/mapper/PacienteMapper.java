package pacientes.salud.elian.mapper;

import pacientes.salud.elian.dto.PacienteDTO;
import pacientes.salud.elian.entity.Paciente;

public class PacienteMapper {

    public static PacienteDTO mapToPacienteDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();

        dto.setIdPaciente(paciente.getIdPaciente());
        dto.setNombre(paciente.getNombre());
        dto.setApellido(paciente.getApellido());
        dto.setEdad(paciente.getEdad());
        dto.setTelefono(paciente.getTelefono());
        dto.setCorreo(paciente.getCorreo());
        dto.setDireccion(paciente.getDireccion());

        return dto;
    }

    public static Paciente mapToPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setIdPaciente(pacienteDTO.getIdPaciente());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setEdad(pacienteDTO.getEdad());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setCorreo(pacienteDTO.getCorreo());
        paciente.setDireccion(pacienteDTO.getDireccion());

        return paciente;
    }
}
