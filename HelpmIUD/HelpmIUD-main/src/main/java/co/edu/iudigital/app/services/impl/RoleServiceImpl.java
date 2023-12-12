package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.RoleDTO;
import co.edu.iudigital.app.models.Role;
import co.edu.iudigital.app.repositories.IRoleRepository;
import co.edu.iudigital.app.services.ifaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> getAll() {

        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        if (roleDTO.getNombre() == null || roleDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        Role role = new Role();
        role.setNombre(roleDTO.getNombre());
        role.setDescripcion(roleDTO.getDescripcion());
        role = roleRepository.save(role);
        return roleDTO;
    }

    @Override
    public RoleDTO getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
