package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // ambigüo
public interface ICasoRepository
        extends JpaRepository<Caso, Long> {
}
