package pacientes.salud.elian.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pacientes.salud.elian.dto.PacienteDTO;
import pacientes.salud.elian.services.PacienteService;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDto) {
        PacienteDTO savedPaciente = pacienteService.createPaciente(pacienteDto);
        return new ResponseEntity<>(savedPaciente, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable("id") Long pacienteId) {
        PacienteDTO pacienteDto = pacienteService.getPacienteById(pacienteId);
        if (pacienteDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pacienteDto);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<PacienteDTO> pacientes = pacienteService.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<PacienteDTO> getPacienteByCorreo(@PathVariable("correo") String correo) {
        PacienteDTO pacienteDto = pacienteService.getPacienteByCorreo(correo);
        if (pacienteDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pacienteDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable("id") Long pacienteId,
            @RequestBody PacienteDTO updatePaciente) {
        PacienteDTO pacienteDto = pacienteService.updatePaciente(pacienteId, updatePaciente);
        if (pacienteDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pacienteDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable("id") Long pacienteId) {
        pacienteService.deletePaciente(pacienteId);
        return ResponseEntity.ok("Registro eliminado");
    }
}
