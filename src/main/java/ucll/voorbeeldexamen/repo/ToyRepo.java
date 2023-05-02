package ucll.voorbeeldexamen.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ucll.voorbeeldexamen.model.Toy;

public interface ToyRepo extends JpaRepository<Toy, Long> {

}
