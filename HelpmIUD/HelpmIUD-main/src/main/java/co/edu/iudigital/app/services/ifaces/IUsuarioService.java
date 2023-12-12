package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getAll(); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

    UsuarioDTO save(UsuarioDTO usuario); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

    UsuarioDTO getById(Long id); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS*/

    UsuarioDTO edit(Long id, UsuarioDTO usuarioDTO);

    void deleteById(Long id);// TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

}
