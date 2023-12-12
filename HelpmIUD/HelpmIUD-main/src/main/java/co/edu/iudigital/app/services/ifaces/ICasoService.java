package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.models.Caso;

import java.util.List;

public interface ICasoService {


   List<Caso> getAll(); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

    CasoDTO save(CasoDTO caso); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

    CasoDTO getById(Long id); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS*/

    CasoDTO edit(Long id, CasoDTO casoDTO);

    void deleteById(Long id);// TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS
}

