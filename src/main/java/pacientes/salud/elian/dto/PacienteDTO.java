package pacientes.salud.elian.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private Long idPaciente;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String telefono;
    private String correo;
    private String direccion;
}
