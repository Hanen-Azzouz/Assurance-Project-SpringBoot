package tn.esprit._3cinfogl1.assuranceproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Beneficiaire;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.TypeContrat;

import java.util.Set;

@Repository
public interface BeneficiaireRepository extends CrudRepository<Beneficiaire,Integer> {

  Beneficiaire getBeneficiaireByCin(int cin);

    @Query(" select alias from Beneficiaire alias join Assurance alias1 on  alias.idBenef=alias1.beneficiaire.idBenef" +
            " join Contrat alias2 on alias1.contract.idContrat=alias2.idContrat " +
            "where alias2.type=?1")
     Set<Beneficiaire> getBeneficiaireByTypeJPQL(TypeContrat typeContrat);



}
