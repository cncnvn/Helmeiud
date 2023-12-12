package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.RoleDTO;
import co.edu.iudigital.app.models.Role;

import java.util.List;

public interface IRoleService {

    List<Role> getAll(); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

    RoleDTO save(RoleDTO role); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS

    RoleDTO getById(Long id); // TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS*/

    void deleteById(Long id);// TODO: AGREGAR LAS EXCEPCIONES PERSONALIZADAS


}
