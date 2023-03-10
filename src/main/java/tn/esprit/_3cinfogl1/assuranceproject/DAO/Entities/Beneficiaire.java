package tn.esprit._3cinfogl1.assuranceproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Beneficiaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBenef;
    int cin;
    String nom;
    String prenom;
    String profession;
    float salaire;
    //Child de Assurance
    @JsonIgnore
    @OneToMany(mappedBy = "beneficiaire")
    private List<Assurance> assurances;
}
