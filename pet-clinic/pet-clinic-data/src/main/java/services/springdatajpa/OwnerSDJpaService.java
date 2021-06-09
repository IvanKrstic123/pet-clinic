package services.springdatajpa;

import model.Owner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import services.OwnerService;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerService ownerService;

    public OwnerSDJpaService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerService.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        return ownerService.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerService.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {
        return ownerService.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerService.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerService.deleteById(aLong);
    }
}
