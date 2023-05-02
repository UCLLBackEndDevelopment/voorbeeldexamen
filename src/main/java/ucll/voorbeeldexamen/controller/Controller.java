package ucll.voorbeeldexamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import ucll.voorbeeldexamen.model.Dog;
import ucll.voorbeeldexamen.model.Toy;
import ucll.voorbeeldexamen.service.DogService;
import ucll.voorbeeldexamen.service.ToyService;

@RestController
@RequestMapping("api")
public class Controller {

    @Autowired
    private DogService dogService;

    @Autowired
    private ToyService toyService;

    @PostMapping("dog/add")
    public Dog addDog(@RequestBody @Valid Dog dog) {
        return dogService.addDog(dog);
    }

    @PostMapping("toy/add")
    public Toy addToy(@RequestBody @Valid Toy toy) {
        return toyService.addToy(toy);
    }

}
