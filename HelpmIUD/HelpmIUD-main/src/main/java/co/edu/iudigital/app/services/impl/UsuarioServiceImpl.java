package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.models.Usuario;
import co.edu.iudigital.app.repositories.IUsuarioRepository;
import co.edu.iudigital.app.services.ifaces.IUsuarioService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    //LISTAR
    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    //CREAR
    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        usuario.setEnabled(usuarioDTO.getEnabled());
        usuario.setImage(usuarioDTO.getImage());
        usuario.setRedSocial(usuarioDTO.getRedSocial());
        usuario = usuarioRepository.save(usuario);
        return usuarioDTO;
    }

    //LISTAR ID
    @Override
    public UsuarioDTO getById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.map(this::mapUsuarioToUsuarioDTO).orElse(null);
    }

    private UsuarioDTO mapUsuarioToUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .password(usuario.getPassword())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .enabled(usuario.getEnabled())
                .image(usuario.getImage())
                .redSocial(usuario.getRedSocial())
                .build();
    }

    //EDITAR
    @SneakyThrows
    @Override
    public UsuarioDTO edit(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
            usuario.setEnabled(usuarioDTO.getEnabled());
            usuario.setImage(usuarioDTO.getImage());
            usuario.setRedSocial(usuarioDTO.getRedSocial());
            usuarioRepository.save(usuario);
            return usuarioDTO;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }

    }

    //ELIMINAR
    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
