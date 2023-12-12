package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.repositories.IDelitoRepository;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import co.edu.iudigital.app.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelitoServiceImpl implements IDelitoService {

    // inyección de dependencias (por atributo)
    @Autowired
    private IDelitoRepository delitoRepository;

    @Autowired
    private Mapper mapper; // mapper de utilidades

    // LISTAR
    @Override
    public List<DelitoDTO> getAll() {
        List<Delito> delitos =  delitoRepository.findAll();
        return mapper.toDelitosDTO(delitos);
    }

    // CREAR
    @Override
    public DelitoDTO save(DelitoDTORequest delitoDTORequest) {
        Delito delito = new Delito();
        delito.setNombre(delitoDTORequest.getNombre());
        delito.setDescripcion(delitoDTORequest.getDescripcion());
        delito = delitoRepository.save(delito);
        return new DelitoDTO(delito.getId(), delito.getNombre(), delito.getDescripcion());
    }


    @Override
    public DelitoDTO edit(Long id, DelitoDTORequest delitoDTORequest) {
        Optional<Delito> delitoOptional = delitoRepository.findById(id);
        if (delitoOptional.isPresent()) {
            Delito delito = delitoOptional.get();
            delito.setNombre(delitoDTORequest.getNombre());
            delito.setDescripcion(delitoDTORequest.getDescripcion());
            delito = delitoRepository.save(delito);
            return new DelitoDTO(delito.getId(), delito.getNombre(), delito.getDescripcion());
        } else {
            throw new RuntimeException("Delito no encontrado con id: " + id);
        }
    }



   @Override
    public DelitoDTO getById(Long id) {
        Optional<Delito> delitoOptional =
                delitoRepository.findById(id);
        DelitoDTO delitoDTO = new DelitoDTO();
        if(delitoOptional.isPresent()) {
            delitoDTO = mapper.toDelitoDTO(
                    delitoOptional.get()
            );
        }
        return delitoDTO;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Delito> delitoOptional = delitoRepository.findById(id);
        if (delitoOptional.isPresent()) {
            delitoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Delito no encontrado con id: " + id);
        }
    }
}