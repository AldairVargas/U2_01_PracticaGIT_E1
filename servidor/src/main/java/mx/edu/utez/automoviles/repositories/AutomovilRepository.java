package mx.edu.utez.automoviles.repositories;

import mx.edu.utez.automoviles.models.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovilRepository extends JpaRepository<Automovil, Long> {
}
