package co.edu.iudigital.app.utils;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.models.Delito;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public DelitoDTO toDelitoDTO(Delito delito){
        return DelitoDTO.builder()
                .id(delito.getId())
                .nombre(delito.getNombre())
                .descripcion(delito.getDescripcion())
                .build();
    }

    public Delito toDelito(DelitoDTO delitoDTO){
        Delito delito = new Delito();
        delito.setId(delitoDTO.getId());
        delito.setNombre(delitoDTO.getNombre());
        delito.setDescripcion(delitoDTO.getDescripcion());
        return delito;
    }

    public Delito toDelito(DelitoDTORequest delitoDTO){
        Delito delito = new Delito();
        delito.setNombre(delitoDTO.getNombre());
        delito.setDescripcion(delitoDTO.getDescripcion());
        return delito;
    }

    public List<DelitoDTO> toDelitosDTO(
            List<Delito> delitos
    ){
        return delitos.stream()
                .map(delito -> toDelitoDTO(delito))
                .collect(Collectors.toList());
    }

    public List<Delito> toDelitos(
            List<DelitoDTO> delitosDTO
    ){
        return delitosDTO.stream()
                .map(delitoDTO -> toDelito(delitoDTO))
                .collect(Collectors.toList());
    }
}
