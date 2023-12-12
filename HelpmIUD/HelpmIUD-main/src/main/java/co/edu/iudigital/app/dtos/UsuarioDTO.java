package co.edu.iudigital.app.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder // patrón
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {


    Long id;

    String username;

    String nombre;

    String apellido;

    String password;

    LocalDate fechaNacimiento;

    Boolean enabled;

    String image;

    Boolean redSocial;

    String roles;
}
