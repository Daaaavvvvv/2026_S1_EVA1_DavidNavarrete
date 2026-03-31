package cl.duoc.DavidNavarete.model;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediTurnModel {
    @NotNull(message = "El rut no puede ser nulo")
    private Long rut;
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String apellido;
    @NotBlank(message = "La edad no puede estar en blanco")
    private int edad;
    @NotBlank(message = "Especialidad o tipo de atencion requerida no puede estar en blanco")
    private String atencion;
    @NotNull(message = "El estado de la solicitud no puede ser nulo")
    private String estado;
    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;
    @NotBlank(message = "La prioridad no puede estar en blanco")
    private String prioridad;



}
