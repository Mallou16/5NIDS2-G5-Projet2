package tn.esprit.spring.kaddem.entities;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EquipeServiceImplTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllEquipes() {
        List<Equipe> equipeList = new ArrayList<>();
        // Populate the list with sample data
        equipeList.add(new Equipe("Equipe1", Niveau.JUNIOR));
        equipeList.add(new Equipe("Equipe2", Niveau.SENIOR));

        Mockito.when(equipeRepository.findAll()).thenReturn(equipeList);

        List<Equipe> result = equipeService.retrieveAllEquipes();

        assertEquals(2, result.size());
    }

    @Test
    public void testAddEquipe() {
        Equipe equipe = new Equipe("New Equipe", Niveau.JUNIOR);
        Mockito.when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(equipe);

        Equipe addedEquipe = equipeService.addEquipe(equipe);

        assertEquals("New Equipe", addedEquipe.getNomEquipe());
    }

    @Test
    public void testDeleteEquipe() {
        Integer id = 1;
        Equipe equipe = new Equipe("To be deleted", Niveau.JUNIOR);

        Mockito.when(equipeRepository.findById(id)).thenReturn(java.util.Optional.of(equipe));

        equipeService.deleteEquipe(id);

        Mockito.verify(equipeRepository, Mockito.times(1)).delete(equipe);
    }


}