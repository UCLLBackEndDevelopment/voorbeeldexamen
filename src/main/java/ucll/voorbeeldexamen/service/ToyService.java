package ucll.voorbeeldexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucll.voorbeeldexamen.model.Toy;
import ucll.voorbeeldexamen.repo.ToyRepo;

@Service
public class ToyService {

    @Autowired
    private ToyRepo toyRepo;

    public Toy addToy(Toy toy) {
        return toyRepo.save(toy);
    }

}
