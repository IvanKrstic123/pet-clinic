package services.springdatajpa;

import model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.SpecialtyRepository;
import services.SpecialityService;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialityService {

    private SpecialtyRepository specialtyRepository;

    @Override
    public Set<Speciality> findAll() {
        return (Set<Speciality>) specialtyRepository.findAll();
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
