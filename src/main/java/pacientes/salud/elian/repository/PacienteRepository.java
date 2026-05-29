package pacientes.salud.elian.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pacientes.salud.elian.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByCurp(String curp);

    boolean existsByCurp(String curp);

    List<Paciente> findByActivoTrue();
}
