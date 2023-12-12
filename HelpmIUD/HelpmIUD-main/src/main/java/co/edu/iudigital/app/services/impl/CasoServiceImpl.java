package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.repositories.ICasoRepository;
import co.edu.iudigital.app.services.ifaces.ICasoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasoServiceImpl implements ICasoService {


    @Autowired
    private ICasoRepository casoRepository;

    @Override
    public List<Caso> getAll() {

        List<Caso> casos = casoRepository.findAll();
        return casos;
    }

    @Override
    public CasoDTO save(CasoDTO casoDTO) {
        Caso caso = new Caso();
        caso.setFechaHora(casoDTO.getFechaHora());
        caso.setLatitud(casoDTO.getLatitud());
        caso.setLongitud(casoDTO.getLongitud());
        caso.setAltitud(casoDTO.getAltitud());
        caso.setIsVisible(casoDTO.getIsVisible());
        caso.setDetalle(casoDTO.getDetalle());
        caso.setUrlMap(caso.getUrlMap());
        caso.setRmiUrl(casoDTO.getRmiUrl());
        caso.setDelito(caso.getDelito());
        caso.setUsuario(caso.getUsuario());
        caso = casoRepository.save(caso);
        return casoDTO;
    }

    @Override
    public CasoDTO getById(Long id) {
        Optional<Caso> optionalCaso = casoRepository.findById(id);
        return optionalCaso.map(this::mapCasoToCasoDTO).orElse(null);
    }

    private CasoDTO mapCasoToCasoDTO(Caso caso) {
        return CasoDTO.builder()
                .id(caso.getId())
                .fechaHora(caso.getFechaHora())
                .latitud(caso.getLatitud())
                .longitud(caso.getLongitud())
                .altitud(caso.getAltitud())
                .isVisible(caso.getIsVisible())
                .detalle(caso.getDetalle())
                .urlMap(caso.getUrlMap())
                .rmiUrl(caso.getRmiUrl())
                .build();
    }

    @SneakyThrows
    @Override
    public CasoDTO edit(Long id, CasoDTO casoDTO) {
        Optional<Caso> optionalCaso = casoRepository.findById(id);
        if (optionalCaso.isPresent()){
            Caso caso = optionalCaso.get();
            caso.setFechaHora(casoDTO.getFechaHora());
            caso.setLatitud(casoDTO.getLatitud());
            caso.setLongitud(casoDTO.getLongitud());
            caso.setAltitud(casoDTO.getAltitud());
            caso.setIsVisible(casoDTO.getIsVisible());
            caso.setDetalle(casoDTO.getDetalle());
            caso.setUrlMap(casoDTO.getUrlMap());
            caso.setRmiUrl(casoDTO.getRmiUrl());
            caso.setDelito(caso.getDelito());
            caso.setUsuario(caso.getUsuario());
            casoRepository.save(caso);
            return casoDTO;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public void deleteById(Long id) {
        casoRepository.deleteById(id);
    }

}

