package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartementServiceImplTest {
    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private DepartementServiceImpl departementService;

    @Test
    void testRetrieveAllDepartements() {

        List<Departement> departementList = new ArrayList<>();



        when(departementRepository.findAll()).thenReturn(departementList);


        List<Departement> result = departementService.retrieveAllDepartements();


        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testAddDepartement() {
        // sample for testing
        Departement sampleDepartement = new Departement();


        // simulation taa mockito
        when(departementRepository.save(any(Departement.class))).thenReturn(sampleDepartement);

        // test
        Departement addedDepartement = departementService.addDepartement(sampleDepartement);

        assertNotNull(addedDepartement);
        assertEquals(sampleDepartement, addedDepartement); // added dep=mockito sample
    }

    @Test
    void testUpdateDepartement() {
        Departement sampleDepartement = new Departement();



        when(departementRepository.save(any(Departement.class))).thenReturn(sampleDepartement);

        Departement updatedDepartement = departementService.updateDepartement(sampleDepartement);

        assertNotNull(updatedDepartement);
        assertEquals(sampleDepartement, updatedDepartement);
    }

    @Test
    void testRetrieveDepartement_WhenPresent() {
        Departement sampleDepartement = new Departement();
        sampleDepartement.setIdDepart(1);


        when(departementRepository.findById(sampleDepartement.getIdDepart())).thenReturn(Optional.of(sampleDepartement));

        Departement retrievedDepartement = departementService.retrieveDepartement(sampleDepartement.getIdDepart());

        assertNotNull(retrievedDepartement);
        assertEquals(sampleDepartement, retrievedDepartement);
    }
    @Test
    void testDeleteDepartement() {
        Departement sampleDepartement = new Departement();

        when(departementRepository.findById(sampleDepartement.getIdDepart())).thenReturn(Optional.of(sampleDepartement));


        departementService.deleteDepartement(sampleDepartement.getIdDepart());


        verify(departementRepository, Mockito.times(1)).delete(sampleDepartement);
    }
}
