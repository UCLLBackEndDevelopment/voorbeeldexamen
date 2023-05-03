package ucll.voorbeeldexamen.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ucll.voorbeeldexamen.model.Dog;

public interface DogRepo extends JpaRepository<Dog, Long> {

}
