package jalkapallo.bookstore.repository;

import jalkapallo.bookstore.domain.Jalkapalloilija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JalkapalloilijaRepository extends JpaRepository<Jalkapalloilija, Long> {
}
