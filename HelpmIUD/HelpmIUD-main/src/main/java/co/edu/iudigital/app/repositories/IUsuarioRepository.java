package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // esto es ambigüo porque extienda a un Bean
public interface IUsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
