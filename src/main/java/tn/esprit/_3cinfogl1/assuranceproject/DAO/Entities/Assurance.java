package tn.esprit._3cinfogl1.assuranceproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int idAssurance;
    String designation;
    float montant;

    //Parent de Contrat
    @JsonIgnore
    @ManyToOne
    private Contrat contract;

    //Parent de beneficiaire
    @JsonIgnore
    @ManyToOne
    private Beneficiaire beneficiaire;

}
