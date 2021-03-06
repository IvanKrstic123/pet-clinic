package model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "owners")
public class Owner extends Person{

    @Builder
    public Owner(Long id, String firstName, String lastName, String adress, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.adress = adress;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }
    @Column(name = "address")
    private String adress;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;



}
