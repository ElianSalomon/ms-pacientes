package pacientes.salud.elian.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
        Paciente paciente = PacienteMapper.mapToPaciente(pacienteDto);
        Paciente savedPaciente = pacienteRepository.save(paciente);
        return PacienteMapper.mapToPacienteDTO(savedPaciente);
    }

    @Override
    public PacienteDTO getPacienteById(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);
        return paciente == null ? null : PacienteMapper.mapToPacienteDTO(paciente);
    }

    @Override
    public List<PacienteDTO> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
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
        paciente.setApellido(updatePaciente.getApellido());
        paciente.setEdad(updatePaciente.getEdad());
        paciente.setTelefono(updatePaciente.getTelefono());
        paciente.setCorreo(updatePaciente.getCorreo());
        paciente.setDireccion(updatePaciente.getDireccion());

        Paciente updatedPaciente = pacienteRepository.save(paciente);
        return PacienteMapper.mapToPacienteDTO(updatedPaciente);
    }

    @Override
    public void deletePaciente(Long pacienteId) {
        pacienteRepository.deleteById(pacienteId);
    }

    @Override
    public PacienteDTO getPacienteByCorreo(String correo) {
        Paciente paciente = pacienteRepository.findByCorreo(correo).orElse(null);
        return paciente == null ? null : PacienteMapper.mapToPacienteDTO(paciente);
    }
}
