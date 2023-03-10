package tn.esprit._3cinfogl1.assuranceproject.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       int idContrat;
    String matricule;
    @Temporal(TemporalType.DATE)
    Date dateEffet;
    @Enumerated(EnumType.STRING)
    TypeContrat type;

}
