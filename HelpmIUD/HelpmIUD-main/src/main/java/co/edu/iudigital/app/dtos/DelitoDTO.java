package co.edu.iudigital.app.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder // patrón
@AllArgsConstructor
@NoArgsConstructor
public class DelitoDTO {

    Long id;

    String nombre;

    String descripcion;
}
