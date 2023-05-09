package ucll.voorbeeldexamen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ucll.voorbeeldexamen.model.Dog;
import ucll.voorbeeldexamen.model.Toy;
import ucll.voorbeeldexamen.repo.DogRepo;

@Service
public class DogService {
    @Autowired
    private DogRepo dogRepo;

    public Dog addDog(Dog dog) {
        return dogRepo.save(dog);
    }

}
