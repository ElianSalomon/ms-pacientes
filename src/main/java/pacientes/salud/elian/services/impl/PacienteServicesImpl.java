package pacientes.salud.elian.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import pacientes.salud.elian.dto.PacienteDTO;
import pacientes.salud.elian.entity.Paciente;
import pacientes.salud.elian.mapper.PacienteMapper;
import pacientes.salud.elian.repository.PacienteRepository;
import pacientes.salud.elian.services.PacienteService;

@Service
@AllArgsConstructor
public class PacienteServicesImpl implements PacienteService {

    private PacienteRepository pacienteRepository;

    @Override
    public PacienteDTO createPaciente(PacienteDTO pacienteDto) {
        if (pacienteDto.getCurp() == null || pacienteDto.getCurp().length() != 18) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La CURP debe tener 18 caracteres");
        }

        if (pacienteRepository.existsByCurp(pacienteDto.getCurp())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La CURP ya existe");
        }

        Paciente paciente = PacienteMapper.mapToPaciente(pacienteDto);
        paciente.setActivo(true);
        Paciente savedPaciente = pacienteRepository.save(paciente);
        return PacienteMapper.mapToPacienteDTO(savedPaciente);
    }

    @Override
    public PacienteDTO getPacienteById(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);
        return paciente == null ? null : PacienteMapper.mapToPacienteDTO(paciente);
    }

    @Override
    public PacienteDTO getPacienteByCurp(String curp) {
        Paciente paciente = pacienteRepository.findByCurp(curp).orElse(null);
        return paciente == null ? null : PacienteMapper.mapToPacienteDTO(paciente);
    }

    @Override
    public List<PacienteDTO> getPacientesActivos() {
        List<Paciente> pacientes = pacienteRepository.findByActivoTrue();
        return pacientes.stream()
                .map(PacienteMapper::mapToPacienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO updatePaciente(Long pacienteId, PacienteDTO updatePaciente) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);

        if (paciente == null) {
            return null;
        }

        paciente.setNombre(updatePaciente.getNombre());
        paciente.setApellidos(updatePaciente.getApellidos());
        paciente.setFechaNacimiento(updatePaciente.getFechaNacimiento());
        paciente.setTipoSangre(updatePaciente.getTipoSangre());
        paciente.setTelefono(updatePaciente.getTelefono());
        paciente.setEmail(updatePaciente.getEmail());

        Paciente updatedPaciente = pacienteRepository.save(paciente);
        return PacienteMapper.mapToPacienteDTO(updatedPaciente);
    }

    @Override
    public void darDeBajaPaciente(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);
        if (paciente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado");
        }
        paciente.setActivo(false);
        pacienteRepository.save(paciente);
    }
}
