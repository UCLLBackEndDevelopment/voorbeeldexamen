package ucll.voorbeeldexamen.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import ucll.voorbeeldexamen.model.Dog;
import ucll.voorbeeldexamen.repo.DogRepo;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    private Dog aValidDogTommie;
    private Dog aValidDogRomeo;
    private List<Dog> listWithDogsAsc;
    private List<Dog> listWithDogsDesc;

    @Mock
    DogRepo dogRepo;

    @InjectMocks
    DogService dogService;

    @BeforeEach
    public void createList() {
        listWithDogsAsc = new ArrayList<>();
        listWithDogsAsc.add(aValidDogRomeo);
        listWithDogsAsc.add(aValidDogTommie);

        listWithDogsDesc = new ArrayList<>();
        listWithDogsDesc.add(aValidDogTommie);
        listWithDogsDesc.add(aValidDogRomeo);
    }

    @Test
    public void givenTwoBooksInRepo_whenSortIsAscedWithOrderABC_thenServiceExceptionIsThrown() {

        // given
        lenient().when(dogRepo.findDogsOrderByNameAsc()).thenReturn(listWithDogsAsc);
        lenient().when(dogRepo.findDogsOrderByNameDesc()).thenReturn(listWithDogsDesc);
        lenient().when(dogRepo.findAll(Sort.by("ABC", "name"))).thenReturn(listWithDogsAsc);
        // when
        ServiceException ex = assertThrows(ServiceException.class, () -> dogService.getDogsSortedBy("ABC"));
        // then
        assertEquals("The order must be ASC or DESC", ex.getMessage());
        assertEquals("order", ex.getField());
    }
}
