package tn.esprit._3cinfogl1.assuranceproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Assurance;

@Repository
public interface AssuranceRepository extends CrudRepository<Assurance,Integer> {

    @Query(value = "select count(beneficiaire_id_benef) from assurance alias join beneficiaire alias1 on alias1.id_benef=alias.beneficiaire_id_benef where alias1.id_benef=?1",nativeQuery = true)
    int nbrAssuranceSQL(int idbf);


}
