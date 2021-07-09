package services.map;

import model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.OwnerService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    final Long ownerId = 1L;
    Owner owner;
    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService();
        owner = ownerService.save(Owner.builder().id(ownerId).lastName("Krstic").build());
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerService.findAll();

        assertEquals(1, all.size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);

        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void delete() {
        ownerService.delete(owner);

        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).firstName("Ivan").lastName("Novakovic").build();
        Owner save = ownerService.save(owner);

        assertEquals(owner.getId(), save.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);

        assertEquals(1L, owner.getId());
    }

    @Test
    void findByLastName() {
        String lastName = "Krstic1";

        Owner ownerByLastName = ownerService.findByLastName(lastName);

        assertNull(ownerByLastName);
    }
}